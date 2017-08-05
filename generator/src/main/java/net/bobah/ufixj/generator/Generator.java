package net.bobah.ufixj.generator;

import freemarker.cache.FileTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import net.bobah.ufixj.repository.Repository;

import java.io.File;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import static freemarker.template.Configuration.VERSION_2_3_23;

/**
 * Hello world!
 *
 */
public class Generator
{
    private static final Logger LOG = Logger.getGlobal();

    public static void main( String[] args ) throws Exception
    {
        final Map<String, Object> root = new HashMap<>();
        root.put("repo", Repository.loadRepository());
        root.put("phrases", Repository.loadPhrases());

        final Path templateDir = Paths.get(System.getProperty("generator.templateDir"));
        final Path outputDir = Paths.get(System.getProperty("generator.outputDir"));
        final String outputNamespace = System.getProperty("generator.outputNamespace");
        root.put("namespace", outputNamespace);

        if (!Files.isDirectory(templateDir))
            throw new IllegalArgumentException("path does not exist: " + templateDir);

        final Configuration fmConfiguration = new Configuration(VERSION_2_3_23);
        fmConfiguration.setTemplateLoader(new FileTemplateLoader(templateDir.toFile()));

        final Path outputNamespaceDir = Paths.get(outputNamespace.replace('.', File.separatorChar));
        final Path outputFullDir = outputDir.resolve(outputNamespaceDir);
        if (Files.notExists(outputFullDir))
            Files.createDirectories(outputFullDir);

        for (Path path : Files.newDirectoryStream(templateDir, "*.ftl")) {
            LOG.info("processing template " + path);
            final String templateFilenameStr = path.getFileName().toString();
            final Template template = fmConfiguration.getTemplate(templateFilenameStr);
            final String codeFilenameStr =
                    Paths.get(templateFilenameStr.substring(0, templateFilenameStr.lastIndexOf("."))) + ".java";
            final Path codePath = outputFullDir.resolve(codeFilenameStr);
            LOG.info("writing " + codePath);
            final Writer out = Files.newBufferedWriter(codePath);
            template.process(root, out);
        }
    }
}

package net.bobah.ufixj.repository;

import net.bobah.ufixj.repository.phrases.Phrases;
import net.bobah.ufixj.repository.repo.FixRepository;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;


/**
 * FIX unified repository loader
 */
public final class Repository
{
    public static FixRepository loadRepository() throws JAXBException {
        return (FixRepository) (JAXBContext
                .newInstance(FixRepository.class)
                .createUnmarshaller()
                .unmarshal(Repository.class.getResourceAsStream("FixRepository.xml")));
    }

    public static Phrases loadPhrases() throws JAXBException {
        return (Phrases)(JAXBContext
                .newInstance(Phrases.class)
                .createUnmarshaller()
                .unmarshal(Repository.class.getResourceAsStream("FIX.5.0SP2_EP228_en_phrases.xml")));
    }
}

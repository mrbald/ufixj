<#ftl>
package ${namespace};
<#assign fix = repo.fix[0]>
public final class Meta {
    <#list fix.datatypes.datatype as datatype>
    <#if !(datatype.baseType)??>
    // base type: ${datatype.name}.class
    </#if>
    </#list>

    // to keep the compiler happy
    public static final class Pattern {}

    <#list fix.datatypes.datatype>
    public static final class DataTypes {
        <#items as datatype>
        <#if (datatype.baseType)??>
        public static final class ${datatype.name} {
            public static Class<?> type = ${datatype.baseType}.class;
        }
        </#if>
        </#items>
    }
    </#list>

    public static final class Fields {
        <#list fix.fields.field as field>
        public static final class ${field.name} {
            public static final int id = ${field.id?c};
            // public static final Class<?> type = DataTypes.${field.type}.class;

            <#list field.enum>
            public static final class Values {
            <#items as value>
                // public static final DataTypes.${field.type} ${value.symbolicName} = ${value.value};
            </#items>
            }
            <#else>
            // not an enum
            </#list>
        }
        </#list>
    }

    <#--
    public static final class Components {
        <#list doc.fixRepository.fix.components.component as component>
        public static final class ${component.@name} {
            public static final int id = ${component.@id};

        }
        </#list>
    }

    public static final class Messages {
        <#list doc.fixRepository.fix.messages.message as message>
        public static final class ${message.@name} {
            public static final int id = ${message.@id};
            public static final String msgType = "${message.@"

        }
        </#list>
    }
    -->
}
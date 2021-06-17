package example.jooq.listener;

import org.jooq.codegen.DefaultGeneratorStrategy;
import org.jooq.meta.Definition;

public class JooqGeneratorStrategy extends DefaultGeneratorStrategy {

    @Override
    public String getJavaClassName(Definition definition, Mode mode) {
        if (Mode.POJO == mode) {
            return super.getJavaClassName(definition, mode).concat("Pojo");
        }

        return super.getJavaClassName(definition, mode);
    }
}

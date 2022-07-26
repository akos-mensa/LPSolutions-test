package com.company.fluentapi.impl;
import com.company.fluentapi.contract.prepareHtml;
import freemarker.template.*;
import java.util.*;
import java.io.*;

public class test implements prepareHtml {
    String templateDir = "./";
    String templateName = "template.ftlh";
    Map data = new HashMap();
    Configuration cfg = new Configuration(Configuration.VERSION_2_3_29);

    public test() {
        // Create and adjust the configuration singleton
        try {
            cfg.setDirectoryForTemplateLoading(new File(templateDir));
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Recommended settings for new projects:
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        cfg.setLogTemplateExceptions(false);
        cfg.setWrapUncheckedExceptions(true);
        cfg.setFallbackOnNullLoopVariable(false);

        // Set default parameters to empty string to avoid missing parameter error
        data.put("name", "");
        data.put("email", "");
        data.put("repo", "");

    }

    public prepareHtml param(String parameter, String value) {
        data.put(parameter, value);
        return this;
    }

    public String genHtml(String template) {
        // create template file from input string
        try (PrintWriter templateOut = new PrintWriter(templateDir + templateName)) {
            templateOut.println(template);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        // Get the template (uses cache internally)
        Template temp = null;
        try {
            temp = cfg.getTemplate(templateName);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Merge data-model with template
        Writer out = new  StringWriter();
        try {
            temp.process(data, out);
        } catch (TemplateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // delete template file
        File templateFile = new File(templateDir+templateName);
        templateFile.delete();

        return out.toString();
    }

}

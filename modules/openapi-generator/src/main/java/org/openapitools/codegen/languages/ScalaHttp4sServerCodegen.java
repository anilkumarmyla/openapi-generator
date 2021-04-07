package org.openapitools.codegen.languages;

import org.openapitools.codegen.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

public class ScalaHttp4sServerCodegen extends AbstractScalaCodegen implements CodegenConfig {
    protected String artifactId;
    protected String artifactVersion;
    protected String groupId;
    protected String invokerPackage;
    public static final String PROJECT_NAME = "projectName";

    static final Logger LOGGER = LoggerFactory.getLogger(ScalaHttp4sServerCodegen.class);

    public CodegenType getTag() {
        return CodegenType.SERVER;
    }

    public String getName() {
        return "scala-http4s";
    }

    public String getHelp() {
        return "Generates a scala-http4s server.";
    }

    public ScalaHttp4sServerCodegen() {
        super();

        outputFolder = "generated-code" + File.separator + "scala-http4s";
        modelTemplateFiles.put("model.mustache", ".scala");
        apiTemplateFiles.put("api.mustache", ".scala");
        embeddedTemplateDir = templateDir = "scala-http4s-server";
        artifactId = "scala-http4s-server";
        artifactVersion = "1.0.0";
        groupId = "org.openapitools";
        invokerPackage = "org.openapitools.server";
        apiPackage = "org.openapitools.server.api";
        modelPackage = "org.openapitools.server.model";

        supportingFiles.add(new SupportingFile("README.mustache", "", "README.md"));
        supportingFiles.add(new SupportingFile("project/build.properties.mustache", "project", "build.properties"));
        supportingFiles.add(new SupportingFile("build.sbt.mustache", "", "build.sbt"));
        supportingFiles.add(new SupportingFile("Main.scala.mustache",
                (sourceFolder + File.separator + invokerPackage).replace(".", File.separator), "Main.scala"));
        supportingFiles.add(new SupportingFile("Http4sServer.scala.mustache",
                (sourceFolder + File.separator + invokerPackage).replace(".", File.separator), "Http4sServer.scala"));

        cliOptions.add(CliOption.newString(CodegenConstants.ARTIFACT_ID, CodegenConstants.ARTIFACT_ID).defaultValue(artifactId));
        cliOptions.add(CliOption.newString(CodegenConstants.ARTIFACT_VERSION, CodegenConstants.ARTIFACT_VERSION_DESC).defaultValue(artifactVersion));
        cliOptions.add(CliOption.newString(CodegenConstants.GROUP_ID, CodegenConstants.GROUP_ID_DESC).defaultValue(groupId));
        cliOptions.add(CliOption.newString(CodegenConstants.INVOKER_PACKAGE, CodegenConstants.INVOKER_PACKAGE_DESC).defaultValue(invokerPackage));
    }

    @Override
    public void processOpts() {
        super.processOpts();

        if (additionalProperties.containsKey(CodegenConstants.ARTIFACT_ID)) {
            artifactId = (String) additionalProperties.get(CodegenConstants.ARTIFACT_ID);
        } else {
            additionalProperties.put(CodegenConstants.ARTIFACT_ID, artifactId);
        }

        if (additionalProperties.containsKey(CodegenConstants.ARTIFACT_VERSION)) {
            artifactVersion = (String) additionalProperties.get(CodegenConstants.ARTIFACT_VERSION);
        } else {
            additionalProperties.put(CodegenConstants.ARTIFACT_VERSION, artifactVersion);
        }

        if (additionalProperties.containsKey(CodegenConstants.GROUP_ID)) {
            groupId = (String) additionalProperties.get(CodegenConstants.GROUP_ID);
        } else {
            additionalProperties.put(CodegenConstants.GROUP_ID, groupId);
        }

        if (additionalProperties.containsKey(CodegenConstants.INVOKER_PACKAGE)) {
            invokerPackage = (String) additionalProperties.get(CodegenConstants.INVOKER_PACKAGE);
        } else {
            additionalProperties.put(CodegenConstants.INVOKER_PACKAGE, invokerPackage);
        }
    }
}

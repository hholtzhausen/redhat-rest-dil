@Library('bitbuild-jenkins-pipeline-library')_

bitbuildMavenContainerPipeline {
  build_agent = 'bitbuild-maven-oci'
  git_credentials = 'git-credential'
  mvn_settings = 'bitbuild-maven-settings'
  registry_creds_prefix = 'bitbuild-registry-auth-json'
  change_set_only = "false"
}

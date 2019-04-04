# Ansible_day_5
## Playbook for jenkins, sonar, nexus, tomcat uses 4 nodes  ##
### List of roles: ###
    1. jenkins
    2. java  - use colects facts
    3. sonar - use check for exist service
    4. nexus - use check for exist service
    5. tomcat 
    6. user  - use for set users for service 
    7. ngnx 
    8. deploy_to_tomcat 
List of files:
    1. inventory
    2. playbook.yml
    3. Vagrantfile

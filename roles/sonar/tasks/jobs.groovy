job('MNTLAB-ydmitriev-main-build-job') {
    parameters {
        activeChoiceReactiveParam('Choose_Jobs') {
           
            choiceType('CHECKBOX')
            groovyScript {
                script('["MNTLAB-ydmitriev-child1-build-job", "MNTLAB-ydmitriev-child2-build-job", "MNTLAB-ydmitriev-child3-build-job", "MNTLAB-ydmitriev-child4-build-job"]')
                fallbackScript('"error"')
        }   }
        activeChoiceReactiveParam('BRANCH_NAME') {
            choiceType('SINGLE_SELECT')
            groovyScript {
                script('["ydmitriev", "master"]')
                fallbackScript('"error"')
            }
        }
    }
    steps{
    	downstreamParameterized {
            trigger('$Choose_Jobs') {
                block {
                    buildStepFailure('FAILURE')
                    failure('FAILURE')
                    unstable('UNSTABLE')
                }
                parameters {
                    predefinedProp('Branch', '$BRANCH_NAME')
                }
            }
        }
    }                      
}
4.times
{
job('MNTLAB-ydmitriev-child${it}-build-job')	{
	parameters {
       activeChoiceReactiveParam('BRANCH_NAME') {
            choiceType('SINGLE_SELECT')
            groovyScript {
                script('["ydmitriev", "master"]')
                fallbackScript('"error"')
            }  
        }    		
    scm{
    	git{
    		remote{
    			url("https://github.com/MNT-Lab/d191l-module.git")
    		}
    	 branch('$BRANCH_NAME')}
    } 
    step{
    	shell('''
    		Bash
    		script.sh > output.txt
    		tar -czf ${BRANCH_NAME}.tar.gz *.txt *.groovy''')
    }
    publishers{
    	archiveArtifacts {
    		pattern('*.tar.gz')
           onlyIfSuccessful() 
        }
    }

}


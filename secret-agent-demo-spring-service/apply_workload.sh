NS=kcd-fr-23
tanzu apps workload apply -f config/workload.yaml  --live-update --local-path . --source-image akseutap4registry.azurecr.io/secret-agent-java-source --namespace $NS --yes  --update-strategy merge

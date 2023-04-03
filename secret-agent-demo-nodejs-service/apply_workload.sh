NS=secret-agent
tanzu apps workload apply -f config/workload.yaml  --live-update --local-path . --source-image akseutap5registry.azurecr.io/sb-nodejs-demo-src --namespace $NS --yes  --update-strategy merge

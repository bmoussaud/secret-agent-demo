

const express = require('express');
const app = express();
const port = process.env.PORT || 3000;

process.env['A_TITLE'] = 'NodeJS App'


try {
  var csb = require('./config-service-binding');
  //toutes les valeurs
  const all = csb.all_bindings()
  //toutes les valeurs pour le type='app-configuration'
  const appBindings = csb.bindings("app-configuration")
  //toutes les valeurs pour le type='app-configuration' et un id specifi
  //const application = csb.bindings("app-configuration","config-alt")

  skippedEntries = ['type']
  Object.entries(appBindings).forEach(([k, v]) => {
    if (!skippedEntries.includes(k)) { process.env[k] = v }
  })
  console.log("<<<-load app Configuration -----------------------------------------------")
} catch (e) {
  console.log(e.message);
}

app.get('/', (req, res) => {
  const envVariablesMap = new Map(Object.entries(process.env).sort());
  const sortedEntriesMap = {}
  skippedEntries = ['WATCHEXEC_COMMON_PATH', 'WATCHEXEC_CREATED_PATH', 'WATCHEXEC_META_CHANGED_PATH', 'WATCHEXEC_REMOVED_PATH', 'WATCHEXEC_WRITTEN_PATH']
  envVariablesMap.forEach((value, key) => {
    if (!skippedEntries.includes(key)) {
      sortedEntriesMap[key] = value
    }
  })

  res.status(200).setHeader('Content-Type', 'application/json').send(JSON.stringify(sortedEntriesMap, null, 2));
});

app.get('/health', (req, res) => {
  res.sendStatus(200);
});

app.listen(port, () => {
  console.log(`App listening at http://localhost:${port}`);
});

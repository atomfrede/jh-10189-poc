const http = require('http');
const path = require("path");
const Tailor = require('node-tailor');
const fetchTemplateFs = require('./lib/fetch-template');
const baseTemplateFn = () => 'base';

const tailor = new Tailor({
    fetchTemplate: fetchTemplateFs(
        path.join(__dirname, 'templates'),
        baseTemplateFn
    )
});
const server = http.createServer(tailor.requestHandler);

server.listen(process.env.PORT || 9000)
import { resolve } from 'path'
import { minifyHtml, injectHtml } from 'vite-plugin-html'

export default ({ mode }) => {

    // const outJS = `out/frontend/${mode === 'production' ? 'fullOpt' : 'fastOpt'}/dest/out.js`
    const outJS = `./out/frontend/${mode === 'production' ? 'fullOpt' : 'fastOpt'}/dest/out.js`
    const scriptTag = `<script type="module" src="${outJS}"></script>`

    return {
        server: {
            proxy: {
                '/api': {
                    target: 'http://localhost:8080',
                    changeOrigin: true,
                    rewrite: (path) => path.replace(/^\/api/, '')
                },
            }
        },
        plugins: [
            ...(process.env.NODE_ENV === 'production' ? [minifyHtml(),] : []),
            injectHtml({
                injectData: {
                    scriptTag
                }
            })
        ]
    }
}

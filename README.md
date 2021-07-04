## How to get started

```sh
git clone https://github.com/daymo/vite_mill_scalajs_issue.git
cd vite_mill_scalajs_issue
yarn

./mill frontend.compile
./mill frontend.fastOpt
```

See: out/frontend/fastOpt/dest/out.js

```sh
yarn exec vite
```

or

```sh
yarn exec vite --debug
```

## Versions used

- yarn 1.22.5
- Node.js 14.17.2
- Vite 2.3.8
- ScalaJS 1.6.0
- Scala 2.13.6
- Mill 0.9.8

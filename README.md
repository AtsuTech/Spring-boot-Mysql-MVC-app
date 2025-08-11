# Spring bootでデータベース接続　&MVCでデータの表示

参考
https://spring.io/guides/gs/accessing-data-mysql
https://spring.io/guides/gs/serving-web-content


DockerのMySQLにアクセス
このspringアプリケーションを使う際は、dockerのデスクトップアプリを立ち上げておく
また、ローカルのマシンでMySQLが動作している場合はSTOPしておく
```
brew services stop mysql
```
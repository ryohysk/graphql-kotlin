# Kotlin + GraphQLのサンプルプロジェクト

## 概要
Kotlinを使用したGraphQLサーバーのサンプルプロジェクトです。
N+1問題の解決などを目的に作成しました。

---
## 技術スタック

### 言語
- Kotlin
- GraphQL

### フレームワーク・ライブラリ
- Spring Boot
- graphql-spring-boot
- Doma
- Flyway

### DB
- MySQL

### その他
- Docker
- Docker Compose

---

## ローカル環境構築

### DB作成

[コチラ](./db/README.md)の手順を実施します。

### 起動
当ディレクトリ直下で以下のコマンドをターミナルで実行します。(IntelliJからGradle>Tasks>application>bootRunでも同様)
```bash
./gradlew bootRun
```

### 動作確認
GraphQLクライアントAltairを使ってクエリを実行することができます。
Altairの[公式](https://altair.sirmuel.design/)からアプリをダウンロードすることができますが、
bootRun実行後に以下のURLにアクセスすることでブラウザで閲覧することもできます。

[Altairをブラウザで開く](http://localhost:8080/altair)

クエリは以下の画像のように実行できます。ドキュメントのフィールドからAdd Queryでクエリを自動生成することもできます。

![クエリ実行例](./img/altair_query_sample.png)
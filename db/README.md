# DB環境構築

## MySQLサーバー作成

以下のコマンドを当ディレクトリ内で実行

```
docker-compose up -d
```

## マイグレーション

Flywayを使ってDB内にデータを挿入します。

```bash
./gradlew -Dflyway.configFiles=db/migration/conf/flyway.conf flywayMigrate
```

# MySQLサーバーの環境情報

| 項目名           | 接続情報       |
|-----------------|---------------|
| ホスト           | 127.0.0.1     |
| ユーザ名         | root          |
| パスワード        | root_password |
| ポート           | 3316          |
| SSL使用          | OFF           |
| 自動構築スキーマ名 | service       |

# phpMyAdmin

データベースクライアントツールは以下を使うことができます。

[phpMyAdmin](http://localhost:55555)

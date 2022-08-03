# 動作確認用テストデータ
## マスターデータ登録
### a) ローカル環境
- ローカル環境では以下のDockerfileでDB構築時に自動的にマスターデータを登録する。
```
nautible-app-ms-product-build/src/test/docker/database/Dockerfile
```

### b) DEV環境
- AWS や Azure 環境では、mysql-client の pod を起動して、product の DB と接続を行い、マスターデータを登録する。

#### mysql-client の pod 起動 / bash 起動
```
kubectl run mysql-client -n nautible-app-ms -it --rm --image=mysql:5.7 --restart=Never -- /bin/bash

※ bash を exit 後は、pod は削除される
```

#### AWS での DB 接続
```
mysql -h product-db.vpc.nautible-dev.com -u root -p
rootpassw0rd
```

#### Azure での DB 接続
```
mysql -h product-fs.product-fs.private.mysql.database.azure.com -u nautible_root -p
Rootpassw0rd
```

#### 実行する DDL / DML
```
nautible-app-ms-product-build/src/main/database/01.schema-product.sql
nautible-app-ms-product-build/src/main/database/02.data-product.sql
```

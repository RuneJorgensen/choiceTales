print('Start #################################################################');

db = db.getSiblingDB('choicetales_prod_db');
db.createUser(
    {
        user: 'api_user',
        pwd: 'api1234',
        roles: [{ role: 'readWrite', db: 'choicetales_prod_db' }],
    },
);
db.createCollection('tale');
db.createCollection('section');

db = db.getSiblingDB('choicetales_dev_db');
db.createUser(
    {
        user: 'api_user',
        pwd: 'api1234',
        roles: [{ role: 'readWrite', db: 'choicetales_dev_db' }],
    },
);
db.createCollection('tale');
db.createCollection('section');

print('END #################################################################');
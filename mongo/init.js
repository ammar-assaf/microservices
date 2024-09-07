db = db.getSiblingDB('Resultdb');
db.createCollection('Results');
db.Results.insertMany([
    {
        max: '99',
        min: '99',
        count: '99',
        avg: '99',
        sum: '99',
        std: '99'
    }
]);
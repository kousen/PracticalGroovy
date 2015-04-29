package db

import groovy.sql.Sql

@Singleton
class GroovyProductDAO implements ProductDAO {
    static Sql sql = Sql.newInstance(
            url: 'jdbc:h2:./build/test', driver: 'org.h2.Driver')

    static {
        sql.execute 'DROP TABLE IF EXISTS product'

        sql.execute '''
            CREATE TABLE product (
                id INT PRIMARY KEY,
                name VARCHAR(25),
                price DOUBLE
            );
         '''

        sql.execute """
            INSERT INTO product VALUES
                (1,'baseball',4.99),
                (2,'football',14.95),
                (3,'basketball',14.99)
            """
    }

    List<Product> getAllProducts() {
        String txt = 'select * from product'
        sql.rows(txt).collect { row ->
            new Product(id: row.id,
                    name: row.name, price: row.price)
        }
    }

    Product findProductById(int id) {
        String txt = 'select * from product where id=?'
        def row = sql.firstRow(txt, [id])

        row ? new Product(id: row.id,
                name: row.name, price: row.price) : null
    }

    void insertProduct(Product p) {
        String txt = 'insert into product(id, name, price) values(?, ?, ?)'
        sql.executeInsert txt, [p.id, p.name, p.price]
    }

    void deleteProduct(int id) {
        String txt = 'delete from product where id=?'
        sql.executeUpdate(txt, [id])
    }
}

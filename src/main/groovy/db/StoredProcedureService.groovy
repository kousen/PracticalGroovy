package db

import groovy.sql.Sql

class StoredProcedureService {
    static Sql sql = Sql.newInstance(
            url:'jdbc:mysql://localhost:3306/sakila',
            driver:'com.mysql.jdbc.Driver',
            user:'root', password:'')

    int getFilmsInStock(filmId, storeId) {
        int result
        sql.call('{call film_in_stock(?,?,?)}',
                [filmId, storeId, Sql.INTEGER]) { count ->
            result = count
        }
        result
    }

    void getFilmsInStock(filmId, storeId, closure) {
        sql.call('{call film_in_stock(?,?,?)}',
                [filmId, storeId, Sql.INTEGER],
                closure)
    }
}

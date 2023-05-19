import io.kotest.core.spec.style.FunSpec
import org.apache.calcite.DataContext
import org.apache.calcite.jdbc.CalciteConnection
import org.apache.calcite.linq4j.Enumerable
import org.apache.calcite.linq4j.Linq4j
import org.apache.calcite.rel.type.RelDataType
import org.apache.calcite.rel.type.RelDataTypeFactory
import org.apache.calcite.rex.RexNode
import org.apache.calcite.schema.FilterableTable
import org.apache.calcite.schema.ScannableTable
import org.apache.calcite.schema.impl.AbstractTable
import org.apache.calcite.sql.type.SqlTypeName
import java.sql.DriverManager

class MyScannableTable : AbstractTable(), ScannableTable {
    override fun getRowType(typeFactory: RelDataTypeFactory): RelDataType {
        return typeFactory.createStructType(
            listOf(typeFactory.createSqlType(SqlTypeName.BIGINT), typeFactory.createSqlType(SqlTypeName.VARCHAR)),
            listOf("ID", "NAME")
        )
    }

    override fun scan(root: DataContext?): Enumerable<Array<Any?>> {
        return Linq4j.asEnumerable(arrayOf(arrayOf(1L, "John")))
    }
}


class MyFilterableTable : AbstractTable(), FilterableTable {
    override fun getRowType(typeFactory: RelDataTypeFactory): RelDataType {
        return typeFactory.createStructType(
            listOf(typeFactory.createSqlType(SqlTypeName.BIGINT), typeFactory.createSqlType(SqlTypeName.VARCHAR)),
            listOf("ID", "NAME")
        )
    }

    override fun scan(root: DataContext?, filters: MutableList<RexNode>?): Enumerable<Array<Any?>> {
        return Linq4j.asEnumerable(arrayOf(arrayOf(1L, "John")))
    }
}


class MinimalTest : FunSpec({

    test("MyScannableTable works") {
        val connection = DriverManager.getConnection("jdbc:calcite:").unwrap(CalciteConnection::class.java)
        connection.rootSchema.add("NAMES", MyScannableTable())
        val statement = connection.createStatement()

        val rs = statement.executeQuery("select name from NAMES where name = 'John'")
        rs.next()

        println("name: ${rs.getString("name")}")
    }

    test("MyFilterableTable fails") {
        suspend {
            val connection = DriverManager.getConnection("jdbc:calcite:").unwrap(CalciteConnection::class.java)
            connection.rootSchema.add("NAMES", MyFilterableTable())
            val statement = connection.createStatement()

            val rs = statement.executeQuery("select name from NAMES where name = 'John'")
            rs.next()

            println("name: ${rs.getString("name")}")
        }.invoke()
    }
})
 
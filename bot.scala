package bot

import scala.swing._
import javax.swing._
import javax.swing.table._
import scala.swing.event.ButtonClicked
import scala.io.Source

class GUI extends MainFrame {
  title = "Codeforces API"
  preferredSize = new Dimension(300, 500)
  homePanel()

  var parsed: Map[String, String] = Map()

  def parse(filename: String) {
    for (line <- Source.fromFile(filename).getLines()) {
      var i = line.indexOf(':')
      var key = line.substring(0, i)
      var value = line.substring(i + 1)
      parsed += (key -> value)
    }
  }

  def homePanel() {
    contents = new BoxPanel(Orientation.Vertical) {
      contents += Button("user info") { problemtag() }
      contents += Swing.VStrut(5)
      contents += Button("user rating") { problemRecent() }
      contents += Swing.VStrut(5)
      contents += Button("problem recent") { problemRecent() }
      contents += Swing.VStrut(5)
      contents += Button("problem statement") { problemRecent() }
      contents += Swing.VStrut(5)
      contents += Button("Close") { close() }
      border = Swing.EmptyBorder(10, 10, 10, 10)
    }
  }

  def problemtag() {
    var z: Array[String] = new Array[String](3)
    parse("/home/sngv/Desktop/user_info.txt")
    var v = MyTable
    v.startup(z)
  }

  def listInfo(username: String) {
    // waiting for json...

  }

  class MyTableModel(var rowData: Array[Array[Any]], val columnNames: Seq[String]) extends AbstractTableModel {
    override def getColumnName(column: Int) = columnNames(column).toString
    def getRowCount() = rowData.length
    def getColumnCount() = columnNames.length
    def getValueAt(row: Int, col: Int): AnyRef = rowData(row)(col).asInstanceOf[AnyRef]
    override def isCellEditable(row: Int, column: Int) = false
    override def setValueAt(value: Any, row: Int, col: Int) {
      rowData(row)(col) = value
    }
    def addRow(data: Array[AnyRef]) {
      rowData ++= Array(data.asInstanceOf[Array[Any]])
    }
  }

  object MyTable extends SimpleSwingApplication {
    def top = new MainFrame {
      title = "MyTable"
      preferredSize = new Dimension(500, 500)
      val tableModel = new MyTableModel(Array[Array[Any]](), List("A", "B"))
      val table = new Table(1, 2) { model = tableModel }

      for (l <- parsed) { tableModel.addRow(Array[AnyRef](l._1, l._2)) }
      //      for (i <- 0 to 30) { tableModel.addRow(Array[AnyRef]("i", "j")) }

      contents = new BorderPanel {
        import BorderPanel.Position._
        add(new ScrollPane(table), Center)
      }
    }
  }

  def problemRecent() {
    var z: Array[String] = new Array[String](3)
    var v = MyTable
    v.startup(z)
  }
}

object bot {

  def main(args: Array[String]) {
    var frame = new GUI
    frame.resizable = false
    frame.visible = true
  }

}
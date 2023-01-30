import scala.collection.mutable.ArrayBuffer


/*
  From a functional programming standpoint, this class has a few problems:
  * All of its fields are mutable.
  * All of the set methods mutate the class fields.
  * The getHistory method returns a mutable data structure.
 */
class Stock(var symbol: String, var company: String, var price: BigDecimal, var volume: Long) {
  var html: String = _
  def buildUrl(stockSymbol: String): String = { _ }
  def getUrlContent(url: String): String = { _ }

  def setPriceFromHtml(html: String) { this.price = _ }
  def setVolumeFromHtml(html: String) { this.volume = _ }
  def setHighFromHtml(html: String) { _ }
  def setLowFromHtml(html: String) { _ }

  private val _history: ArrayBuffer[Stock] = { _ }
  val getHistory = _history
}


// As a first step towards fixing the issues, there should be the concept of a Stock, which just contains basic,
// static information about the Stock
case class StockInfo(symbol: String, company: String)


// Second, we can create a class that represents the stock's performance at any given point in time (i.e., a snapshot)
case class StockSnapshot(symbol: String, datetime: String, price: BigDecimal, volume: Long, high: BigDecimal,
                         low: BigDecimal)

// Third, the getUrlContent method is not class-specific, so it should be moved to an object
object NetworkUtils {
  def getUrlContent(url: String): String = { _ }
}

// Fourth, the buildUrl method again is not class-specific, so it should also be moved to an object
// Fifth, the ability to extract a stock price from HTML can also be moved to the object
// Sixth, by following steps 4 and 5, we notice that we can actually move all of the set methods to this object
// These methods are all PURE FUNCTIONS
/*
  Pure function definition:
  * The function always evaluates to the same result value given the same argument value(s).
  * It cannot depend on any hidden state or value, and it cannot depend on any I/O.
  * Evaluation of the result does not cause any semantically observable side effect or output, such as mutation of
    mutable objects or output to I/O devices.
 */
object StockUtils {
  def buildUrl(stockSymbol: String): String = { _ }
  def getPriceFromHtml(stockSymbol: String, html: String): BigDecimal = { _ }
  def getVolumeFromHtml(stockSymbol: String, html: String): Long = { _ }
  def getHighFromHtml(stockSymbol: String, html: String): BigDecimal = { _ }
  def getLowFromHtml(stockSymbol: String, html: String): BigDecimal = { _ }
}

// Seventh, by following the same process, the date and time are moved to a utils object
object DateUtils {
  def currentDate: String = { _ }
  def currentTime: String = { _ }
}

// Finally, by putting all of this together, we can create a stock
val stock = StockInfo("AAPL", "Apple")
val url = StockUtils.buildUrl(stock.symbol)
val html = NetworkUtils.getUrlContent(url)

val price = StockUtils.getPriceFromHtml(stock.symbol, html)
val volume = StockUtils.getVolumeFromHtml(stock.symbol, html)
val high = StockUtils.getHighFromHtml(stock.symbol, html)
val low = StockUtils.getLowFromHtml(stock.symbol, html)
val date = DateUtils.currentDate
val stockInstance = StockSnapshot(stock.symbol, date, price, volume, high, low)

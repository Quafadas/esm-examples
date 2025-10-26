package facades

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import scala.concurrent.Future
import scala.scalajs.js.Thenable.Implicits.*
import org.scalajs.dom.{IDBObjectStore, IDBRequest, IDBTransaction}

object idbKeyval:

  @JSImport("@idb-keyval", JSImport.Namespace)
  @js.native
  private val raw: js.Dynamic = js.native

  type UseStore = js.Function2[
    /* txMode */ String,
    /* callback */ js.Function1[/* store */ IDBObjectStore, Any | js.Promise[Any]],
    js.Promise[Any]
  ]

  // ----- clear -----
  inline def clear(): Future[Unit] =
    raw.clear().asInstanceOf[js.Promise[Unit]].toFuture

  inline def clear(customStore: UseStore): Future[Unit] =
    raw.clear(customStore).asInstanceOf[js.Promise[Unit]].toFuture

  // ----- createStore -----
  inline def createStore(dbName: String, storeName: String): UseStore =
    raw.createStore(dbName, storeName).asInstanceOf[UseStore]

  // ----- del -----
  inline def del(key: String): Future[Unit] =
    raw.del(key).asInstanceOf[js.Promise[Unit]].toFuture

  inline def del(key: String, customStore: UseStore): Future[Unit] =
    raw.del(key, customStore).asInstanceOf[js.Promise[Unit]].toFuture

  // ----- delMany -----
  inline def delMany(keys: js.Array[String]): Future[Unit] =
    raw.delMany(keys).asInstanceOf[js.Promise[Unit]].toFuture

  inline def delMany(keys: js.Array[String], customStore: UseStore): Future[Unit] =
    raw.delMany(keys, customStore).asInstanceOf[js.Promise[Unit]].toFuture

  // ----- entries -----
  inline def entries[KeyType <: String, ValueType](): Future[js.Array[(KeyType, ValueType)]] =
    raw.entries().asInstanceOf[js.Promise[js.Array[(KeyType, ValueType)]]].toFuture

  inline def entries[KeyType <: String, ValueType](customStore: UseStore): Future[js.Array[(KeyType, ValueType)]] =
    raw.entries(customStore).asInstanceOf[js.Promise[js.Array[(KeyType, ValueType)]]].toFuture

  // ----- get -----
  inline def get[T](key: String)(using ec: scala.concurrent.ExecutionContext): Future[Option[T]] =
    raw.get(key).asInstanceOf[js.Promise[js.UndefOr[T]]].toFuture.map(_.toOption)

  inline def get[T](key: String, customStore: UseStore)(using ec: scala.concurrent.ExecutionContext): Future[Option[T]] =
    raw.get(key, customStore).asInstanceOf[js.Promise[js.UndefOr[T]]].toFuture.map(_.toOption)

  // ----- getMany -----
  inline def getMany[T](keys: js.Array[String]): Future[js.Array[T]] =
    raw.getMany(keys).asInstanceOf[js.Promise[js.Array[T]]].toFuture

  inline def getMany[T](keys: js.Array[String], customStore: UseStore): Future[js.Array[T]] =
    raw.getMany(keys, customStore).asInstanceOf[js.Promise[js.Array[T]]].toFuture

  // ----- keys -----
  inline def keys[KeyType <: String](): Future[js.Array[KeyType]] =
    raw.keys().asInstanceOf[js.Promise[js.Array[KeyType]]].toFuture

  inline def keys[KeyType <: String](customStore: UseStore): Future[js.Array[KeyType]] =
    raw.keys(customStore).asInstanceOf[js.Promise[js.Array[KeyType]]].toFuture

  // ----- promisifyRequest -----
  inline def promisifyRequest[T](request: IDBRequest[Any, T]): Future[T] =
    raw.promisifyRequest(request).asInstanceOf[js.Promise[T]].toFuture

  inline def promisifyRequest[T](request: IDBTransaction): Future[T] =
    raw.promisifyRequest(request).asInstanceOf[js.Promise[T]].toFuture

  // ----- set -----
  inline def set(key: String, value: js.Any): Future[Unit] =
    raw.set(key, value).asInstanceOf[js.Promise[Unit]].toFuture

  inline def set(key: String, value: js.Any, customStore: UseStore): Future[Unit] =
    raw.set(key, value, customStore).asInstanceOf[js.Promise[Unit]].toFuture

  // ----- setMany -----
  inline def setMany(entries: js.Array[(String, js.Any)]): Future[Unit] =
    raw.setMany(entries).asInstanceOf[js.Promise[Unit]].toFuture

  inline def setMany(entries: js.Array[(String, js.Any)], customStore: UseStore): Future[Unit] =
    raw.setMany(entries, customStore).asInstanceOf[js.Promise[Unit]].toFuture

  // ----- update -----
  inline def update[T](key: String, updater: js.Function1[js.UndefOr[T], T]): Future[Unit] =
    raw.update(key, updater).asInstanceOf[js.Promise[Unit]].toFuture

  inline def update[T](key: String, updater: js.Function1[js.UndefOr[T], T], customStore: UseStore): Future[Unit] =
    raw.update(key, updater, customStore).asInstanceOf[js.Promise[Unit]].toFuture

  // ----- values -----
  inline def values[T](): Future[js.Array[T]] =
    raw.values().asInstanceOf[js.Promise[js.Array[T]]].toFuture

  inline def values[T](customStore: UseStore): Future[js.Array[T]] =
    raw.values(customStore).asInstanceOf[js.Promise[js.Array[T]]].toFuture

end idbKeyval
# Kütüphane Yönetim Sistemi API

Bu proje, bir kütüphanenin envanterini yönetmek için geliştirilmiş bir RESTful API'dir. Spring Boot ve PostgreSQL kullanılarak oluşturulmuştur.

## Proje Hakkında

Bu API, kütüphanedeki kitapları, yazarları, kategorileri, yayınevlerini ve ödünç alma kayıtlarını yönetmek için temel CRUD (Oluşturma, Okuma, Güncelleme, Silme) işlemlerini sunar. Katmanlı mimari kullanılarak geliştirilmiştir ve hata yönetimi için özel istisna (exception) sınıfları içerir.

## Kullanılan Teknolojiler

*   **Java 21**: Programlama dili
*   **Spring Boot 3.5.7**: Ana framework
*   **Spring Data JPA**: Veritabanı işlemleri için ORM
*   **PostgreSQL**: Veritabanı
*   **Maven**: Proje yönetim ve derleme aracı

## Nasıl Çalıştırılır?

1.  Projeyi klonlayın veya indirin.
2.  `application.properties` dosyasında PostgreSQL veritabanı bağlantı ayarlarınızı yapılandırın.
3.  Projeyi bir IDE (IntelliJ IDEA, Eclipse, vb.) üzerinden çalıştırın veya terminalde `mvn spring-boot:run` komutunu kullanın.
4.  Uygulama varsayılan olarak `http://localhost:8081` adresinde çalışmaya başlayacaktır.
5.  Database port 5434
## API Endpoints

Proje aşağıdaki temel endpoint'leri içerir:

*   `/api/authors` - Yazarları yönetmek için.
*   `/api/books` - Kitapları yönetmek için.
*   `/api/categories` - Kategorileri yönetmek için.
*   `/api/publishers` - Yayınevlerini yönetmek için.
*   `/api/borrowings` - Kitap ödünç alma işlemlerini yönetmek için.

## Yazar

**Burak**

`Back-End Developer | Java | Spring Boot | PostgreSQL`

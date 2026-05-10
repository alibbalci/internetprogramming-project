# İSG Yönetim Sistemi

Bu proje, Jakarta EE ve GlassFish kullanılarak geliştirilen eğitim amaçlı basit bir İSG Yönetim Sistemi web uygulamasıdır.

Projenin amacı; firma yönetimi, kurumsal bilgiler ve temel kayıt işlemlerini Jakarta EE yapısı içinde uygulamalı olarak geliştirmektir.

## Kullanılan Teknolojiler

- Java
- Jakarta EE
- Jakarta Faces / JSF
- XHTML
- CSS
- GlassFish Server
- Maven
- IntelliJ IDEA

## Proje Yapısı

```text
src/main/webapp
├── app
│   └── firma
│       └── firma-listesi.xhtml
│
├── panel
│   └── index.xhtml
│
├── resources
│   └── css
│       └── style.css
│
└── WEB-INF
    └── web.xml
```

## Modüller

### Panel

Uygulamanın giriş ekranıdır. Kullanıcı buradan firma yönetimi gibi sayfalara yönlendirilir.

### Firma Yönetimi

Firma bilgileri üzerinde temel işlemlerin yapılacağı bölümdür.

Planlanan işlemler:

- Firma ekleme
- Firma listeleme
- Firma güncelleme
- Firma silme

### Kurumsal Yönetim

Uygulamayı kullanan kuruma ait bilgilerin yönetileceği bölümdür.

Planlanan bilgiler:

- Kurum adı
- Adres
- Telefon
- Yetkili kişi
- Çalışan bilgileri

## Projeyi Çalıştırma

1. Projeyi IntelliJ IDEA ile açın.
2. GlassFish Server yapılandırmasını yapın.
3. Projeyi `war` olarak deploy edin.
4. GlassFish sunucusunu çalıştırın.
5. Tarayıcıdan aşağıdaki adrese gidin:

```text
http://localhost:8080/isg-yonetim-jakarta/
```

Eğer context path farklıysa, IntelliJ içindeki GlassFish Deployment ayarlarından application context değerini kontrol edin.

Örnek:

```text
http://localhost:8080/isg-yonetim-jakarta_war_exploded/
```

## Amaç

Bu proje ticari bir uygulama değildir. Ders kapsamında Jakarta EE, JSF, XHTML sayfa yapısı, GlassFish üzerinde deploy işlemi ve temel web uygulaması geliştirme mantığını öğrenmek amacıyla hazırlanmıştır.

## Geliştirme Planı

- [X] Proje temel klasör yapısının oluşturulması
- [X] Firma yönetim sayfasının hazırlanması
- [X] Firma ekleme işlemi
- [X] Firma listeleme işlemi
- [X] Firma güncelleme işlemi
- [X] Firma silme işlemi
- [X] Kurumsal yönetim sayfasının eklenmesi
- [X] Arayüz tasarımının iyileştirilmesi

## Not

Bu proje, ders kapsamında hocanın gösterdiği Jakarta EE ve GlassFish proje yapısına uygun olarak hazırlanmıştır.
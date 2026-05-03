İSG Firma Takip Sistemi — Proje Açıklaması ve Yol Haritası

1. Proje fikri

Hocamız proje konusunu serbest bıraktı ancak önemli bir şart koydu:

Projede derste gösterilen yapının dışına çıkılmayacak.

Bu yüzden bizim proje fikrimiz, mevcut elimizdeki İş Sağlığı ve Güvenliği sistemini tamamen
kopyalamak değil; onu hocanın anlattığı Jakarta EE / JSF / JPA / EJB yapısına uygun şekilde
sadeleştirmek olacak.

Proje adımız şu olabilir:

İSG Firma Takip Sistemi

Bu proje, bir OSGB veya İSG hizmeti veren kurumun hizmet verdiği firmaları ve bu firmalara
bağlı çalışanları takip etmesini sağlar.

2. Neden bu projeyi seçiyoruz?

Elimizde daha önce geliştirdiğimiz İSG mantığına benzeyen bir sistem var. Bu sistemde firma
yönetimi, çalışan yönetimi, işe giriş yönetimi, saha gözlem yönetimi gibi birçok modül
bulunuyor.

Fakat bu ödev için tüm modülleri yapmak mantıklı değil. Çünkü hocanın örnek projesi daha
çok basit CRUD işlemleri üzerine kurulu.

Bu yüzden projeyi şu üç ana modülle sınırlıyoruz:

Kurumsal Yönetim
Firma Yönetimi
Çalışan Yönetimi
Bu kapsam yeterli, anlaşılır ve hocanın gösterdiği proje yapısına uygundur.

3. Kullanacağımız teknolojiler

Hocanın örnek projesine bağlı kalmak için şu teknolojileri kullanacağız:

Java
Maven
WAR packaging
Jakarta EE
JSF / XHTML
JPA

EJB
PostgreSQL
Bootstrap
Session Filter

Yani proje klasik bir Java web uygulaması olacak.

Kullanıcı arayüzleri .xhtml dosyalarıyla hazırlanacak.
Veritabanı işlemleri JPA ve EntityManager ile yapılacak.
CRUD işlemleri Facade sınıfları üzerinden yönetilecek.
Sayfaların arka plan mantığı Bean sınıflarıyla yazılacak.

4. Kullanmayacağımız teknolojiler

Hocanın kapsamı dışına çıkmamak için özellikle şu teknolojileri kullanmayacağız:

Spring Boot
React
REST API
JWT
Spring Security
Lombok
DTO
Service katmanı
Docker
Excel import/export
PDF/Word çıktı alma
Yapay zeka analizi
Grafikli dashboard

Bunlar gerçek projelerde kullanılabilir ama hocanın örnek projesinde yok. Bu yüzden ödevde
kullanmak riskli olur.

5. Projenin genel amacı

Projenin amacı, İSG hizmeti veren bir kurumun temel kayıtlarını yönetmesini sağlamaktır.

Sistem üzerinden:

Kurum bilgileri kaydedilecek.
Hizmet verilen firmalar kaydedilecek.
Firmalara bağlı çalışanlar kaydedilecek.

Kullanıcı sisteme giriş yapacak.
Giriş yapmayan kullanıcı panel sayfalarına erişemeyecek.

Yani sistem, basit bir İSG firma ve çalışan takip sistemi olacak.

6. Projenin ana modülleri

6.1. Kullanıcı Girişi

Sisteme giriş yapılabilmesi için login sayfası olacak.

Kullanıcı:

E-posta
Şifre

bilgileriyle giriş yapacak.

Giriş başarılı olursa kullanıcı panel sayfasına yönlendirilecek.
Giriş başarısız olursa hata mesajı verilecek.

Bu yapı hocanın örnek projesindeki LoginBean, Users, UserFacade yapısına benzer şekilde
yapılacak.

6.2. Kurumsal Yönetim

Bu modül, uygulamayı kullanan kurumun bilgilerini tutacak.

Örneğin bir OSGB veya İSG danışmanlık şirketi bu sistemi kullanıyor olabilir. Kurumsal
Yönetim sayfasında bu kurumun temel bilgileri tutulacak.

Alanlar:

Kurum adı
Adres
Telefon
E-posta
Yetkili kişi
Vergi numarası
SGK sicil numarası

Bu modülde yapılacak işlemler:

Kurum bilgisi ekleme
Kurum bilgisi listeleme

Kurum bilgisi düzenleme
Kurum bilgisi silme

Normalde sistemde tek kurum bilgisi olabilir. Ama hocanın CRUD mantığına uygun olması için
bunu liste şeklinde yapmak daha kolay ve daha anlaşılır olur.

6.3. Firma Yönetimi

Bu modül projenin ana modülü olacak.

İSG hizmeti verilen firmalar bu sayfada kaydedilecek.

Firma alanları:

Ünvan
SGK sicil numarası
NACE kodu
İş kolu
Tehlike sınıfı
SGK sicil adresi
Yetkili kişi
Telefon
E-posta

Bu modülde yapılacak işlemler:

Firma ekleme
Firma listeleme
Firma düzenleme
Firma silme

Bu sayfa, elimizdeki mevcut JavaFX İSG projesindeki “Firma Yönetimi” ekranının
sadeleştirilmiş web karşılığı olacak.

Ancak Excel’den ekleme, dışa aktarma, örnek Excel dosyası gibi işlemler bu ödevde
yapılmayacak. Çünkü hocanın örnek projesinde bu yapılar yok.

6.4. Çalışan Yönetimi

Bu modülde firmalara bağlı çalışanlar tutulacak.

Çalışan alanları:

Ad
Soyad

TC kimlik no
Telefon
E-posta
Görev
Departman
İşe giriş tarihi
Bağlı olduğu firma

Buradaki önemli nokta şudur:

Bir çalışan bir firmaya bağlı olacak.
Bir firmanın birden fazla çalışanı olabilir.

Ama teknik olarak çok karmaşık ilişkilere girmemek için Employee entity’sinde sadece şu
ilişkiyi kurmak yeterli:

@ManyToOne
private Company company;

Yani çalışan tablosunda firma bilgisi tutulacak.

Bu modülde yapılacak işlemler:

Çalışan ekleme
Çalışan listeleme
Çalışan düzenleme
Çalışan silme

Çalışan eklerken firma seçimi yapılacak. Bunun için JSF tarafında h:selectOneMenu
kullanılabilir.

7. Projenin teknik mimarisi

Hocanın örnek projesine göre paket yapımız şu şekilde olacak:

src/main/java
│
├── bean
├── entity
├── facade
├── facadeLocal
└── filter

Bu paketlerin görevleri şöyledir:

7.1. entity paketi

Veritabanı tablolarını temsil eden sınıflar burada olacak.

Kullanacağımız entity sınıfları:

Users.java
Institution.java
Company.java
Employee.java

Görevleri:

Users → Sisteme giriş yapan kullanıcı bilgileri
Institution → Sistemi kullanan kurum bilgileri
Company → Hizmet verilen firma bilgileri
Employee → Firmalara bağlı çalışan bilgileri

7.2. bean paketi

XHTML sayfalarının arkasındaki Java sınıfları burada olacak.

Kullanacağımız bean sınıfları:

LoginBean.java
UserBean.java
InstitutionBean.java
CompanyBean.java
EmployeeBean.java

Görevleri:

LoginBean → Giriş işlemlerini yönetir
UserBean → Kullanıcı işlemlerini yönetir
InstitutionBean → Kurumsal yönetim sayfasını yönetir
CompanyBean → Firma yönetim sayfasını yönetir
EmployeeBean → Çalışan yönetim sayfasını yönetir

Bean sınıfları formdan gelen verileri alır, ilgili facade sınıfına gönderir ve sayfadaki
listeleme/güncelleme/silme işlemlerini yönetir.

7.3. facade paketi

Veritabanı işlemlerini yapan sınıflar burada olacak.

Kullanacağımız facade sınıfları:

AbstractFacade.java
UserFacade.java
InstitutionFacade.java
CompanyFacade.java
EmployeeFacade.java

Görevleri:

create
edit
remove
list
find
login

gibi işlemleri EntityManager üzerinden gerçekleştirmek.

Bu yapıda Spring Repository kullanılmayacak.

7.4. facadeLocal paketi

EJB interface dosyaları burada olacak.

Kullanacağımız interface’ler:

UserFacadeLocal.java
InstitutionFacadeLocal.java
CompanyFacadeLocal.java
EmployeeFacadeLocal.java

Bean sınıfları doğrudan facade sınıflarını değil, genellikle bu local interface’leri kullanacak.

Örnek:

@EJB
private CompanyFacadeLocal companyFacade;

7.5. filter paketi

Oturum kontrolü burada yapılacak.

Kullanacağımız sınıf:

SessionFilter.java

Bu sınıf, kullanıcı giriş yapmadan panel sayfalarına erişmeye çalışırsa onu login sayfasına
yönlendirecek.

Örneğin şu sayfalar korunacak:

/panel/*

8. Web sayfa yapısı

Web tarafındaki dosyalar şu şekilde olabilir:

src/main/webapp
│
├── index.xhtml
├── login.xhtml
├── template.xhtml
├── institution.xhtml
├── company.xhtml
├── employee.xhtml
│
├── panel
│ └── index.xhtml
│
├── WEB-INF
│ └── web.xml
│
└── resources
├── css
└── js

Sayfaların görevleri:

login.xhtml → Kullanıcı giriş sayfası
template.xhtml → Ortak sayfa tasarımı
panel/index.xhtml → Girişten sonra açılan ana panel
institution.xhtml → Kurumsal Yönetim sayfası
company.xhtml → Firma Yönetimi sayfası
employee.xhtml → Çalışan Yönetimi sayfası

Arayüz için Bootstrap kullanılacak. Çok karmaşık tasarım yapılmayacak.

9. Sayfa tasarımı nasıl olacak?

Sayfalar temel olarak şu yapıda olacak:

Üst menü
Sol menü
Ana içerik alanı

Sol menüde şunlar olacak:

Kurumsal Yönetim
Firma Yönetimi
Çalışan Yönetimi

Ana içerik alanında ise seçilen modülün formu ve tablosu bulunacak.

Örneğin Firma Yönetimi sayfası:

Firma Yönetimi

[Ünvan ]
[SGK Sicil No ]
[NACE Kodu ]
[İş Kolu ]
[Tehlike Sınıfı ]
[SGK Sicil Adresi ]
[Yetkili Kişi ]
[Telefon ]
[E-Posta ]

[Kaydet] [Güncelle] [Temizle]

Firma Listesi

Ünvan | SGK Sicil No | NACE Kodu | Tehlike Sınıfı | Telefon | İşlemler

İşlemler kısmında:

Düzenle
Sil

butonları olacak.

10. Veritabanı tasarımı

Minimum veritabanı tabloları:

users
institution
company
employee

10.1. users tablosu

id
name
surname
email
password

10.2. institution tablosu

id
name
address
phone
email
authorized_person
tax_number
sgk_number

10.3. company tablosu

id
title
sgk_number
nace_code
business_line
hazard_class
sgk_address
authorized_person
phone
email

10.4. employee tablosu

id
first_name
last_name
tc_no
phone
email

job_title
department
start_date
company_id

company_id, çalışan ile firma arasında ilişki kuracak.

11. Projede yapılacak temel işlemler

Kullanıcı işlemleri

Kullanıcı giriş yapabilir.
Kullanıcı çıkış yapabilir.
Giriş yapmayan kullanıcı panel sayfalarına erişemez.

Kurum işlemleri

Kurum eklenebilir.
Kurum listelenebilir.
Kurum düzenlenebilir.
Kurum silinebilir.

Firma işlemleri

Firma eklenebilir.
Firma listelenebilir.
Firma düzenlenebilir.
Firma silinebilir.

Çalışan işlemleri

Çalışan eklenebilir.
Çalışan listelenebilir.
Çalışan düzenlenebilir.
Çalışan silinebilir.
Çalışan bir firmaya bağlanabilir.

12. Geliştirme sırası

Projeyi karışık yapmamak için şu sırayla ilerleyeceğiz:

Hocanın örnek projesi çalıştırılacak.
Proje adı değiştirilecek.
Login sistemi çalışıyor mu kontrol edilecek.
Template ve menü sadeleştirilecek.
Company entity oluşturulacak.
CompanyFacadeLocal oluşturulacak.
CompanyFacade oluşturulacak.
CompanyBean oluşturulacak.
company.xhtml sayfası oluşturulacak.
Firma ekleme ve listeleme yapılacak.
Firma silme eklenecek.
Firma düzenleme eklenecek.
Institution entity oluşturulacak.
Institution CRUD işlemleri yapılacak.
Employee entity oluşturulacak.
Employee ile Company arasında ilişki kurulacak.
EmployeeFacadeLocal oluşturulacak.
EmployeeFacade oluşturulacak.
1 9. EmployeeBean oluşturulacak.
employee.xhtml sayfası oluşturulacak.
Çalışan ekleme, listeleme, silme, düzenleme yapılacak.
SessionFilter kontrol edilecek.
Son testler yapılacak.
Proje raporu hazırlanacak.
En önemli kural:
Önce firma modülü tamamlanacak, sonra çalışan modülüne geçilecek. Çünkü çalışan firmaya
bağlı olacak.

13. Grup içi görev paylaşımı önerisi

Grup içinde görevleri şöyle paylaşabiliriz.

Kişi 1 — Proje kurulumu ve genel yapı

Sorumluluklar:

Hocanın projesini çalıştırmak
Proje adını değiştirmek
pom.xml kontrolü
persistence.xml kontrolü
web.xml kontrolü
template.xhtml düzenlemek
menü yapısını hazırlamak

Kişi 2 — Firma Yönetimi

Sorumluluklar:

Company.java
CompanyFacadeLocal.java
CompanyFacade.java
CompanyBean.java
company.xhtml
Firma ekleme
Firma listeleme
Firma silme
Firma düzenleme

Kişi 3 — Kurumsal Yönetim

Sorumluluklar:

Institution.java
InstitutionFacadeLocal.java
InstitutionFacade.java
InstitutionBean.java
institution.xhtml
Kurum ekleme
Kurum listeleme
Kurum silme
Kurum düzenleme

Kişi 4 — Çalışan Yönetimi

Sorumluluklar:

Employee.java
EmployeeFacadeLocal.java
EmployeeFacade.java
EmployeeBean.java
employee.xhtml
Firma seçerek çalışan ekleme
Çalışan listeleme
Çalışan silme
Çalışan düzenleme

Grup 3 kişiyse Kurumsal Yönetim ve genel yapı aynı kişide olabilir.

14. Riskli noktalar

Projede dikkat edilmesi gereken bazı riskler var.

14.1. Çalışan-firma ilişkisi

Employee ile Company arasında ilişki olacağı için çalışan ekleme kısmı diğerlerinden biraz
daha zordur.

Bu yüzden önce firma CRUD’u tamamlanmalı.

14.2. Çok fazla modül ekleme riski

Ekrandaki eski İSG sisteminde çok modül var ama biz bu ödevde hepsini yapmayacağız.

Yapılmayacak modüller:

İşe Giriş Yönetimi
Görevlendirme Yönetimi
Saha Gözlem Yönetimi
İSG Kurulları Yönetimi
DÖF Yönetimi
Yıllık Planlama
Eğitim Yönetimi
Ramak Kala
Acil Durum Eylem Planı
Tatbikat Yönetimi
Risk Değerlendirme

Bunlar ileride genişletilebilir ama ödev kapsamına alınmayacak.

14.3. Excel / PDF / Word işlemleri

Mevcut JavaFX sisteminde Excel ve Word işlemleri olabilir. Ama bu ödevde koymayacağız.

Çünkü hocanın gösterdiği yapının dışına çıkma riski var.

14.4. Spring Boot kullanmama

Bu proje kesinlikle Spring Boot projesi olmayacak.

Doğru yapı:

Jakarta EE + JSF + JPA + EJB

Yanlış yapı:

Spring Boot + React

15. Teslimde söyleyeceğimiz kısa açıklama

Projeyi savunurken şöyle anlatabiliriz:

Bu projede İş Sağlığı ve Güvenliği alanında hizmet veren bir kurumun
firma ve çalışan kayıtlarını yönetebileceği basit bir web uygulaması geliştirdik.

Proje, hocamızın derste gösterdiği Jakarta EE mimarisine uygun olarak hazırlanmıştır.
Arayüzlerde JSF ve XHTML kullanılmıştır.
Veritabanı işlemleri JPA EntityManager üzerinden yapılmıştır.
CRUD işlemleri EJB Facade sınıflarıyla yönetilmiştir.
Kullanıcı oturum kontrolü SessionFilter ile sağlanmıştır.

Projede Kurumsal Yönetim, Firma Yönetimi ve Çalışan Yönetimi modülleri bulunmaktadır.

16. Projenin minimum başarılı hali

En kötü ihtimalle teslimde şu özellikler kesin çalışmalı:

Login ekranı çalışmalı.
Panel ekranı açılmalı.
Firma eklenebilmeli.
Firma listelenebilmeli.
Firma düzenlenebilmeli.
Firma silinebilmeli.
Kurum bilgisi eklenebilmeli.
Çalışan eklenebilmeli.
Çalışan bir firmaya bağlanabilmeli.
Giriş yapmadan panel sayfasına girilememeli.

Bunlar çalışıyorsa proje mantıklı ve yeterli olur.

17. Son karar

Bu projede mevcut İSG sistemimizin fikrini kullanacağız ama teknolojisini değiştireceğiz.

Mevcut sistem mantığı:

JavaFX masaüstü İSG uygulaması

Ödevde yapacağımız sistem:

Jakarta EE tabanlı web İSG firma takip sistemi

Kapsam:

Login
Kurumsal Yönetim
Firma Yönetimi
Çalışan Yönetimi
Teknoloji:

Java
Jakarta EE
JSF / XHTML
JPA
EJB
PostgreSQL
Bootstrap
WAR

Bu haliyle proje hem bizim İSG fikrimize bağlı kalır hem de hocanın derste gösterdiği yapıdan
dışarı çıkmaz.
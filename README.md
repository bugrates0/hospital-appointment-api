# <h1 align="center"> :hospital: **HospitalAppointmentAPI** :ambulance: </h1>

 ###     Bu uygulama, hastaların doktor randevusu alabilmelerini sağlayan bir backend arayüzü projesidir. Hastaların ve doktorların sisteme kaydedilerek belirli tarih ve saatlerde randevular oluşturulabilmesi esasına dayanır.



___
## :man_technologist: Kullanılan Teknolojiler

- #### **Framework:**  <img alt="Spring Boot" src="https://img.shields.io/badge/Spring Boot-3.2.3-brightgreen.svg" />
    + Spring Data JPA
    + Spring Security
    + Spring Validation
    + Spring DevTools
    + Spring Test
    + MySQL Connector
    + Lombok
    + ModelMapper 3.1.1
- #### **Programlama dili:**   <img alt="Java" src="https://img.shields.io/badge/Java->= 17-brightgreen.svg" />
- #### **Veritabanı:** <img alt="MySQL" src="https://img.shields.io/badge/MySQL-8.1.0-brightgreen.svg" />
- #### **Proje yönetim aracı:**  <img alt="Maven" src="https://img.shields.io/badge/Maven-4.0-brightgreen.svg" />
<br/><br/>
> [!NOTE]
> Daha fazla bilgi için <kbd>pom.xml</kbd> dosyasını inceleyiniz.
___
## :bulb: Teknik Ayrıntılar :mag:
Bu proje RESTful prensipleri ve katmanlı mimari tasarım desenini baz alan bir REST API'dır. Günümüzde sağlık başta olmak üzere birçok sektörde kullanılan online randevu-rezervasyon sistemlerinden esinlenilerek geliştirilmiştir.

<img src="https://github.com/bugrates0/hospital-appointment-api/assets/127054766/bc01622b-80b0-4e39-bfc2-14f132e442cc" alt="Açıklama" width="300">


- ### Temel Varlıklar: <kbd>Admin</kbd> <kbd>Klinik</kbd> <kbd>Doktor</kbd> <kbd>Hasta</kbd> <kbd>Randevu</kbd>
    + Bir hastanede pek çok klinik ve bu kliniklere bağlı olarak çalışan doktorlar bulunur. Bu projede de öncelikle hastanede hangi kliniklerin bulunacağı ve bu kliniklere bağlı olarak hangi doktorların çalışacağı belirlenir ve veritabanına eklenir. Daha sonrasında doktorlardan randevu alacak olan hastalar sisteme kaydolur. Hastalar, doktorların çalıştığı gün ve saatlere uygun olarak belirledikleri zaman için randevu alırlar.

- ### Veritabanı Tasarımı
    + **Klinikler Tablosu**
     <br/><br/>
      
  | Sütun İsmi | Veri Tipi    | Açıklama                |
  | ----------- | ------------ | --------------------------- |
  | id    | INT          | Benzersiz klinik numarası |
  | clinic_name  | VARCHAR(255) | Klinik ismi         |

  + **Kullanıcılar Tablosu**
     <br/><br/>
      
   | Sütun İsmi | Veri Tipi    | Açıklama                |
   | ----------- | ------------ | --------------------------- |
   | dtype    | VARCHAR(31) | Eklenen kullanıcının ait olduğu sınıf |
   | id    | INT | Benzersiz kullanıcı numarası |
   | email  | VARCHAR(255) | Benzersiz kullanıcı maili  |
   | first_name    | VARCHAR(255)| Kullanıcı ismi |
   | last_name  | VARCHAR(255) | Kullanıcı soyadı |
   | password  | VARCHAR(255) | Kullanıcının şifresi |
   | role  | VARCHAR(255) | Kullanıcının sistemdeki rolü |
   | clinic_id  | INT | Kullanıcı eğer doktorsa bağlı olduğu klinik numarası |

  
  
  + **Randevular Tablosu**
     <br/><br/>
      
  | Sütun İsmi | Veri Tipi    | Açıklama                |
  | ----------- | ------------ | --------------------------- |
  | id    | INT | Benzersiz randevu numarası |
  | appointment_date  | DATE | Randevu günü |
  | appointment_time  | TIME(6) | Randevu saati |
  | doctor_id    | INT | Randevu alınan doktor numarası |
  | patient_id  | INT | Randevu alan hasta numarası |

- ### REST API Uç Noktaları (Endpoints) ve Kullanım Akışı

  
> [!NOTE]
> Bu kısımda uygulamanın kullanımına dair ayrıntılar Postman Mock Service'den alınmış test ve ekran görüntüleriyle anlatılacaktır.
> Endpointlere istek gönderilmeden önce gerekli kimlik doğrulama bilgileri aşağıdaki gibi girilmelidir. Endpointlerin yetkilendirilme işlemi roller (Hasta, Doktor, Admin) üzerinden gerçekleştirilmektedir.
> ![authentication](https://github.com/bugrates0/hospital-appointment-api/assets/127054766/718b9daa-cdd4-482d-8696-4e8ccd2ced44)



    
   + Uygulama başlatıldığında veritabanına hazır olarak bir Admin kullanıcısı eklenir. Admin kullanıcıları, bu online randevu sistemini ayarlayacak ve kontrol edecek kişilerdir. İlk olarak sisteme kullanım senaryosuna göre gerekli klinikler eklenmelidir.
 
      <kbd>POST /api/admin/clinics</kbd>
      
      <img src="https://github.com/bugrates0/hospital-appointment-api/assets/127054766/29c481a3-4414-429b-a9fd-0d77631ecf57" alt="Açıklama" width="500">
    

      

   + Yine adminler tarafından, bu kliniklere bağlı olarak çalışacak olan doktorların hesapları sisteme kaydedilir.

     <kbd>POST /api/register/doctor</kbd>
      
      <img src="https://github.com/bugrates0/hospital-appointment-api/assets/127054766/6f0ef5ae-03e9-48dd-9436-8bf3a4e374db" alt="Açıklama" width="500">


   + Randevu almak isteyen hastalar öncelikle sisteme kaydolurlar.
     
       <kbd>POST /api/register</kbd>
      
      <img src="https://github.com/bugrates0/hospital-appointment-api/assets/127054766/20075a59-6bea-4f90-bf56-5319af529ce8" alt="Açıklama" width="500">


   + Hastalar, kayıtlı klinikleri ve bu kliniklere bağlı çalışan doktorları öğrenirler.
     
       <kbd>GET /api/clinics</kbd>
      
      <img src="https://github.com/bugrates0/hospital-appointment-api/assets/127054766/53a1a1fb-e81a-4032-836e-e402916beab1" alt="Açıklama" width="500">

   + Randevu almak istedikleri doktoru belirledikten sonra randevu günü boş olan saatleri öğrenirler.
     
       <kbd>GET /api/appointments/{doctorId}/{appointmentDate}</kbd>
      
      <img src="https://github.com/bugrates0/hospital-appointment-api/assets/127054766/fbb07828-f627-4e73-9d30-879b17122009" alt="Açıklama" width="500">

      
  + Uygun olan gün ve saati seçerek randevu alırlar.


       <kbd>POST /api/appointments</kbd>
      
      <img src="https://github.com/bugrates0/hospital-appointment-api/assets/127054766/74a50185-c72e-48cf-a3d2-9429f135a085" alt="Açıklama" width="500">


  + Hastalar aldıkları randevuları görebilirler.

      <kbd>GET /api/appointments</kbd>
      
      <img src="https://github.com/bugrates0/hospital-appointment-api/assets/127054766/c94e9df5-ad58-4d90-9041-cd8e784c5b29" alt="Açıklama" width="500">


 + Vazgeçtikleri randevuları iptal edebilirler.
    
     <kbd>DELETE /api/appointments/{appointmentId}</kbd>
      
      <img src="https://github.com/bugrates0/hospital-appointment-api/assets/127054766/ca8f7a2e-e987-4851-a8b7-389520e73424" alt="Açıklama" width="500">

+ Bu temel özellikler dışında doktorlar sistemde hangi saatlerde hasta muayenesine gireceklerini görebilmektedir.

> [!CAUTION]
> Silme işlemlerinde, eğer silinmeye çalışılan veri başka bir tabloyla bağlantılıysa silinemeyecektir! (Foreign keys)

> [!TIP]
> Yeni randevu oluşturulmak istendiğinde aşağıdaki enum classlarına uygun şekilde tarih ve saat seçimi gerçekleştirilmelidir.
> 
> <img src="https://github.com/bugrates0/hospital-appointment-api/assets/127054766/672d8e30-81dc-45ae-90f3-319ab774ad57" alt="Açıklama" width="500">
> <img src="https://github.com/bugrates0/hospital-appointment-api/assets/127054766/9888bbb8-f312-4c6a-b47f-8cc7292f853e" alt="Açıklama" width="500">
___

## :soon: Eklenecek Özellikler :clock5:
  + Gelişmiş hata yönetimi
  + Veri girişinde RegEx kontrolü
  + Randevu alma/iptal etme işlemlerini admin kullanıcısı tarafından da yapabilme



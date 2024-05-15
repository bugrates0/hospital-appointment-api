# <h1 align="center"> :hospital: **HospitalAppointmentAPI** :ambulance: </h1>

 ###     Bu uygulama, hastaların doktor randevusu alabilmelerini sağlayan bir backend arayüzü sağlar. Hastaların ve doktorların sisteme kaydedilerek belirli tarih ve saatlerde randevular oluşturulabilmesi esasına dayanır.



___
## :man_technologist: Kullanılan Teknolojiler

- #### **Framework:**  <img alt="Spring Boot" src="https://img.shields.io/badge/Spring Boot-3.2.3-brightgreen.svg" />
    + Spring Data JPA
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

<img src="https://github.com/bugrates0/hospital-appointment-api/assets/127054766/6f49d7f6-40f5-4083-9159-0c3fa322462b" alt="Açıklama" width="300">



- ### Temel Varlıklar: <kbd>Klinik</kbd> <kbd>Doktor</kbd> <kbd>Hasta</kbd> <kbd>Randevu</kbd>
    + Bir hastanede pek çok klinik ve bu kliniklere bağlı olarak çalışan doktorlar bulunur. Bu projede de öncelikle hastanede hangi kliniklerin bulunacağı ve bu kliniklere bağlı olarak hangi doktorların çalışacağı belirlenir ve veritabanına eklenir. Daha sonrasında doktorlardan randevu alacak olan hastalar sisteme kaydolur/kaydedilir. Son olaraksa hastalara doktorların çalıştığı gün ve saatlere uygun olarak belirledikleri zaman için randevu verilir.

- ### Veritabanı Tasarımı
    + **Klinikler Tablosu**
     <br/><br/>
      
  | Sütun İsmi | Veri Tipi    | Açıklama                |
  | ----------- | ------------ | --------------------------- |
  | id    | INT          | Benzersiz klinik numarası |
  | clinic_name  | VARCHAR(255) | Klinik ismi         |

  + **Doktorlar Tablosu**
     <br/><br/>
      
   | Sütun İsmi | Veri Tipi    | Açıklama                |
   | ----------- | ------------ | --------------------------- |
   | id    | INT | Benzersiz doktor numarası |
   | email  | VARCHAR(255) | Benzersiz doktor maili  |
   | first_name    | VARCHAR(255)| Doktor adı |
   | last_name  | VARCHAR(255) | Doktor soyadı |
   | clinic_id  | INT | Bağlı bulunduğu klinik numarası |

  + **Hastalar Tablosu**
     <br/><br/>
      
  | Sütun İsmi | Veri Tipi    | Açıklama                |
  | ----------- | ------------ | --------------------------- |
  | id    | INT | Benzersiz hasta numarası |
  | email  | VARCHAR(255) | Benzersiz hasta maili |
  | first_name    | VARCHAR(255)| Hasta adı |
  | last_name  | VARCHAR(255) | Hasta soyadı |
  
  + **Randevular Tablosu**
     <br/><br/>
      
  | Sütun İsmi | Veri Tipi    | Açıklama                |
  | ----------- | ------------ | --------------------------- |
  | id    | INT | Benzersiz randevu numarası |
  | appointment_date  | DATE | Randevu günü |
  | appointment_time  | TIME(6) | Randevu saati |
  | doctor_id    | INT | Randevu alınan doktor numarası |
  | patient_id  | INT | Randevu alan hasta numarası |

- ### REST API Uç noktaları (Endpoints)
    + **Klinik Yönetimi**
      + Yeni klinik oluşturma <kbd>POST /api/clinics</kbd>
      <img src="https://github.com/bugrates0/hospital-appointment-api/assets/127054766/64e072fb-a86d-49e9-a4cf-4052399f7a43" alt="Açıklama" width="500">
        
      + Mevcut tüm klinikleri ve kliniklere bağlı doktorları listeleme <kbd>GET /api/clinics</kbd>
      <img src="https://github.com/bugrates0/hospital-appointment-api/assets/127054766/d35e8be3-3d26-4d19-ba25-dcc1214c5d98" alt="Açıklama" width="500">



    + **Doktor Yönetimi**
      + Yeni doktor kaydı <kbd>POST /api/doctors</kbd>
      <img src="https://github.com/bugrates0/hospital-appointment-api/assets/127054766/1de22f7a-9c0d-4b9d-80de-254606e2baa1" alt="Açıklama" width="500">
      
      + ID'ye göre doktor listeleme <kbd>GET /api/doctors/{doctorId}</kbd>
      + Mevcut bir doktoru silme  <kbd>DELETE /api/doctors/{doctorId}</kbd>
      + Mevcut tüm doktorları listeleme <kbd>GET /api/doctors</kbd>


    + **Hasta Yönetimi**
      + Yeni hasta kaydı <kbd>POST /api/patients</kbd>
      <img src="https://github.com/bugrates0/hospital-appointment-api/assets/127054766/315fb576-b96f-42b5-958f-20481df278b0" alt="Açıklama" width="500">
      
      + ID'ye göre hasta listeleme <kbd>GET /api/patients/{patientId}</kbd>
      + Mevcut bir hastayı silme  <kbd>DELETE /api/patients/{patientId}</kbd>
      <img src="https://github.com/bugrates0/hospital-appointment-api/assets/127054766/bdfea5ae-c624-40a5-83e3-68863b17fa00" alt="Açıklama" width="500">
      
      + Mevcut tüm hastaları listeleme <kbd>GET /api/patients</kbd>


    + **Randevu Yönetimi**
      + Yeni randevu kaydı <kbd>POST /api/appointments</kbd>
      <img src="https://github.com/bugrates0/hospital-appointment-api/assets/127054766/39410f91-64b8-48e7-82d4-0d2a7b965e4a" alt="Açıklama" width="500">
<br/><br/>

> [!CAUTION]
> Silme işlemlerinde, eğer silinmeye çalışılan veri başka bir tabloyla bağlantılıysa silinemeyecektir! (Foreign keys)

> [!TIP]
> Yeni randevu oluşturulmak istendiğinde aşağıdaki enum classlarına uygun şekilde tarih ve saat seçimi gerçekleştirilmelidir.
> <img src="https://github.com/bugrates0/hospital-appointment-api/assets/127054766/672d8e30-81dc-45ae-90f3-319ab774ad57" alt="Açıklama" width="500">
> <img src="https://github.com/bugrates0/hospital-appointment-api/assets/127054766/9888bbb8-f312-4c6a-b47f-8cc7292f853e" alt="Açıklama" width="500">
___

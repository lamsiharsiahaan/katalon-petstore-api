# Katalon Petstore API Automation

Project automation testing untuk **Swagger Petstore REST API** menggunakan **Katalon Studio**. Project ini dirancang dinamis, modular, bebas *hardcode*, dan menerapkan alur pengujian *End-to-End* (*data chaining*).

---

## 📋 1. Project Description
Project ini bertujuan untuk memvalidasi fungsionalitas dan ketahanan REST API pada endpoint Petstore (`https://petstore.swagger.io/v2/pet`). 

**Fitur Utama:**
* **Dynamic Data Chaining**: Nilai `petId` dihasilkan secara otomatis dari skenario *POST*, kemudian diteruskan ke skenario *GET*, *PUT*, dan *DELETE* tanpa ketergantungan `GlobalVariable`.
* **Zero Hardcode**: Seluruh parameter dikonfigurasi melalui *Test Case Variables* dan *Object Repository Placeholders* (`${petId}`, `${petName}`).

---

## 🎯 2. Test Coverage & Test Suite

### **Test Coverage**
Memuat 8 skenario pengujian utama (Positif & Negatif):

1. **POST /pet (Create)**
   * `TC_API_Pet_Positive_CreatePet_001`: Berhasil membuat data pet baru dan menyimpan ID dinamis.
   * `TC_API_Pet_Negative_CreatePet_002`: Validasi penolakan server terhadap data/body yang invalid.
2. **GET /pet/{petId} (Read)**
   * `TC_API_Pet_Positive_GetPetById_003`: Berhasil mengambil data pet menggunakan ID dari hasil POST.
   * `TC_API_Pet_Negative_GetPetByIdInvalid_004`: Memastikan response `404 Not Found` saat pencarian ID fiktif.
3. **PUT /pet (Update)**
   * `TC_API_Pet_Positive_UpdatePet_005`: Berhasil memperbarui nama & status pet secara real-time.
   * `TC_API_Pet_Negative_UpdatePetInvalid_006`: Validasi error saat update dengan ID/data invalid.
4. **DELETE /pet/{petId} (Delete & Cleanup)**
   * `TC_API_Positive_DeletedPet_007`: Berhasil menghapus data pet dari server menggunakan ID dinamis.
   * `TC_API_Pet_Negative_DeletedPet_008`: Memastikan response `404 Not Found` saat menghapus ID yang tidak ada.

### **Test Suite Execution Flow**
Rangkaian eksekusi E2E dijalankan secara berurutan:
`POST (Create) -> GET (Verify) -> PUT (Update) -> GET (Verify Update) -> DELETE (Cleanup)`

---

## ⚙️ 3. How to Run (Cara Menjalankan)

1. **Clone Repository**:
   ```bash
   git clone [https://github.com/lamsiharsiahaan/katalon-petstore-api.git](https://github.com/lamsiharsiahaan/katalon-petstore-api.git)

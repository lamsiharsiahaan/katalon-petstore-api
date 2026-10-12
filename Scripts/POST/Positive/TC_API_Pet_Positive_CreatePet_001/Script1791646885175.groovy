import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

// Pertama, menggunakan variabel petId, petName, petStatus, dan categoryName yang dikirim dari Test Data(Data Binding)
println("Menguji pembuatan pet dengan ID: " + petId + "Nama: " + petName + "categori nama:" + categoryName)

// Kedua, kirim Request POST /pet dengan variabel dari Excel
def response = WS.sendRequest(findTestObject('ObjectRepo_POST/Post_API_Pet', [
    ('petId') : petId,
    ('petName') : petName,
    ('petStatus') : petStatus
]))

// Ketiga, validasi Status Code dan Response Body dan harus 200 OK
WS.verifyResponseStatusCode(response, 200)

// Ke-empat ambil ID yang diberikan oleh respons
def actualId = WS.getElementPropertyValue(response, 'id')
println("ID yang didapat: " + actualId)

// Simpan ID dari respons POST ke Global Variable agar otomatis dipakai di GET/PUT/DELETE
GlobalVariable.petId = actualId.toString()

// Kelima, buat assertion property lainnya
WS.verifyElementPropertyValue(response, 'name', petName)
WS.verifyElementPropertyValue(response, 'status', petStatus)
WS.verifyElementPropertyValue(response, 'category.name', categoryName)

println("Pet ID tersimpan: " + GlobalVariable.petId)


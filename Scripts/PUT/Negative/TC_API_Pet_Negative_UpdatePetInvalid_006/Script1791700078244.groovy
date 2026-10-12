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

// Cek apakah menggunakan ID yang tidak valid
println("Menguji apakah menggunakan ID invalid: " + invalidPetId)
println("Update dengan nama: " + petName + " dan status: " + petStatus)

// Kirim request PUT
def response = WS.sendRequest(findTestObject('ObjectRepo_PUT/Put_API_Pet', [
    ('petId') : invalidPetId,
    ('petName') : petName,
    ('petStatus') : petStatus
]))

// Memverifikasi status code dari respons server
int statusCode = response.getStatusCode()
println("Status code yang diterima dari server: " + statusCode)

// Assertion dan Validasi bahwa status code menunjukkan kegagalan
assert statusCode >= 400 : "Test Gagal: Server malah menerima input teks sebagai ID!"

println("Server menolak format ID yang tidak valid.")


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

// Mencari PetId yang tidak ada di database (misal: 0 atau angka sembarang)
def invalidPetId = "0"

println("Menguji GET dengan ID yang tidak terdaftar: " + invalidPetId)

// Menggunakan Object Repository 'Get_API_PetById'
def response = WS.sendRequest(findTestObject('ObjectRepo_GET/Get_API_PetById', [
	('petId') : invalidPetId
]))

// Validasi bahwa server tidak menemukan data (Status Code 404 Not Found)
WS.verifyResponseStatusCode(response, 404)

// Verifikasi pesan error dari server
WS.verifyElementPropertyValue(response, 'message', 'Pet not found')

println("GET Negative Test Berhasil! Sistem sukses menangani ID yang tidak ditemukan.")
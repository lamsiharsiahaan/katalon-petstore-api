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

// Coba menggunakan ID fiktif atau format salah dari variable yang dibuat
def IdPet = invalidPetId

println('Menguji DELETE dengan ID yang tidak valid: ' + IdPet)

// Kirim request DELETE menggunakan Object Repository
def response = WS.sendRequest(findTestObject('ObjectRepo_DELETE/Delete_API_Pet', [
    ('petId') : invalidPetId
]))

def statusCode = response.getStatusCode()
println('Status Code DELETE: ' + statusCode)

// Pastikan bahwa server menolak permintaan hapus ini (status code >= 400)
assert statusCode >= 400 : 'Test Gagal: Server malah mengizinkan penghapusan untuk ID fiktif!'

println('Server sukses menolak penghapusan ID yang tidak valid.')


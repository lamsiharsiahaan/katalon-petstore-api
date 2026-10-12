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

// Menampilkan id yang ingin dihapus yang diambil dari globalvariable
println('hapus Pet dengan ID: ' + GlobalVariable.petId)

// Kirim request DELETE menggunakan GlobalVariable.petId yang sudah dibuat sebelumnya
def response = WS.sendRequest(findTestObject('ObjectRepo_DELETE/Delete_API_Pet', [
    ('petId') : GlobalVariable.petId
]))

def statusCode = response.getStatusCode()
println("Actual Status Code DELETE: " + statusCode)

// Validasi Status Code 200 OK(berhasil dihapus) dan 404 jika ID sudah tidak ada
assert statusCode == 200 || statusCode == 404 : "Test Gagal: Status code tidak sesuai ekspektasi penghapusan (" + statusCode + ")"

println("delete positive test selesai dengan Status Code: " + statusCode)


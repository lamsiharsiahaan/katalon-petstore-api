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

// Menggunakan variabel yang dikirim dari Test Case Variables / Data Binding
println("Menguji dengan data invalid -> ID: " + petId + ", Nama: " + petName + ", Status: " + petStatus)

// Negative Case: Mengirim ID dengan nilai string huruf
def response = WS.sendRequest(findTestObject('ObjectRepo_POST/Post_API_Pet', [
    ('petId') : petId,
    ('petName') : petName,
    ('petStatus') : petStatus
]))

int statusCode = response.getStatusCode()
println("status code yang didapat: " + statusCode)

// Memastikan server menolak request invalid 
assert statusCode != 200 : "Test Gagal: Request invalid harusnya ditolak"

println("berhasil menolak data invalid.")
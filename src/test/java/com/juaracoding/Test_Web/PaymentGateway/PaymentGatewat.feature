Feature: PaymentGateway from payment module

Scenario: Input PaymentGateway
Given berada di halaman produk
When pilih quantity tertentu
When menekan tombol buy now
When berada di halaman payment process
When isi card number "4934468677218077"
When pilih expiration month
When pilih expiration year
When  isi CVV code "800"
When menekan tombol pay
Then dapat order id
#Ahmad Chaidar SQA Batch 7
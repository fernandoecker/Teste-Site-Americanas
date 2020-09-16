# Teste-Site-Americanas
Cenarios de testes automatizado da tela de novos usuarios do site da Americanas

O projeto foi desenvolvido em Java e Selenium.
É necessario importar as dependecias pelo Maven.

Os testes estão no package br.com.ecker.tests, na classe CadastroTest.
O site da Americanas, após clicar em "criar seu cadastro", pode solicitar para resolver um captcha, para isso coloquei um tempo de até 90 segundos para resolução e apresentação a mensagem validada. Se passar do tempo ou não apresentar a mensagem será considerado erro.

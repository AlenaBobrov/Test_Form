##### Тест-Кейсы:

**№1. Отправка формы "Вывод средств со счета" с использованием корректного значения в поле "Вывести" :**
1. Перейти на страницу https://groall.noda.pro/test_qa;
2. Выбрать "Москва" в поле Выбор офиса обслуживания, если это поле появилось;
3. Ввести в поле "Вывести" значение "10" ;
4. Кликнуть по кнопке "Вывести"; 

##### Ожидаемый результат: Сообщений ошибках нет. Появляется PopUp с сообщением "Токены списаны, всего списано 1000, осталось 121000." Сумма токенов, оставшихся на счете пользователя уменьшилась на 1000, на экране показывается "Баланс: 121000 токенов".
##### Приоритет (Priority) - High

**№2. Отправка формы "Вывод средств со счета" с использованием дробного числа с разделителем "точка" в поле "Вывести" :**
1. Перейти на страницу https://groall.noda.pro/test_qa;
2. Выбрать "Москва" в поле Выбор офиса обслуживания, если это поле появилось;
3. Ввести в поле "Вывести" значение "0.01" ;
4. Кликнуть по кнопке "Вывести";

##### Ожидаемый результат: Сообщений ошибках нет. Появляется PopUp с сообщением "Токены списаны, всего списано 1, осталось 121999."Сумма токенов, оставшихся на счете пользователя уменьшилась на 1, на экране показывается "Баланс: 121999 токенов".
##### Приоритет (Priority) - High

**№3. Отправка формы "Вывод средств со счета" с использованием дробного числа с разделителем "запятая" в поле "Вывести" :**
1. Перейти на страницу https://groall.noda.pro/test_qa;
2. Выбрать "Москва" в поле Выбор офиса обслуживания, если это поле появилось;
3. Ввести в поле "Вывести" значение "0,01" ;
4. Кликнуть по кнопке "Вывести";

##### Ожидаемый результат: Сообщение об ошибке - "Неверный формат!"
##### Приоритет (Priority) - Medium

**№4. Отправка формы "Вывод средств со счета" с пустым значением в поле "Вывести" :**
1. Перейти на страницу https://groall.noda.pro/test_qa;
2. Выбрать "Москва" в поле Выбор офиса обслуживания, если это поле появилось;
3. Оставить поле "Вывести" пустым ;
4. Кликнуть по кнопке "Вывести";

##### Ожидаемый результат: Сообщение об ошибке - "Поле обязательно для заполнения"
##### Приоритет (Priority) - Medium

**№5. Отправка формы "Вывод средств со счета" с использованием спецсимвола в поле "Вывести" :**
1. Перейти на страницу https://groall.noda.pro/test_qa;
2. Выбрать "Москва" в поле Выбор офиса обслуживания, если это поле появилось;
3. Ввести в поле "Вывести" значение "%" ;
4. Кликнуть по кнопке "Вывести";

##### Ожидаемый результат: Сообщение об ошибке - "Поле должно содержать только цифры!"
##### Приоритет (Priority) - Medium

**№6. Отправка формы "Вывод средств со счета" с использованием латинских символов в поле "Вывести" :**
1. Перейти на страницу https://groall.noda.pro/test_qa;
2. Выбрать "Москва" в поле Выбор офиса обслуживания, если это поле появилось;
3. Ввести в поле "Вывести" значение "dfgd" ;
4. Кликнуть по кнопке "Вывести";

##### Ожидаемый результат: Сообщение об ошибке - "Поле должно содержать только цифры!"
##### Приоритет (Priority) - Medium

**№7. Отправка формы "Вывод средств со счета" с использованием кириллических символов в поле "Вывести" :**
1. Перейти на страницу https://groall.noda.pro/test_qa;
2. Выбрать "Москва" в поле Выбор офиса обслуживания, если это поле появилось;
3. Ввести в поле "Вывести" значение "ововово" ;
4. Кликнуть по кнопке "Вывести";

##### Ожидаемый результат: Сообщение об ошибке - "Поле должно содержать только цифры!"
##### Приоритет (Priority) - Medium

**№8. Отправка формы "Вывод средств со счета" используя написанное латинскими буквами значение суммы в поле "Вывести" :**
1. Перейти на страницу https://groall.noda.pro/test_qa;
2. Выбрать "Москва" в поле Выбор офиса обслуживания, если это поле появилось;
3. Ввести в поле "Вывести" значение "one" ;
4. Кликнуть по кнопке "Вывести";

##### Ожидаемый результат: Сообщение об ошибке - "Поле должно содержать только цифры!"
##### Приоритет (Priority) - Medium

**№9. Отправка формы "Вывод средств со счета" используя написанное кириллицей значение суммы в поле "Вывести" :**
1. Перейти на страницу https://groall.noda.pro/test_qa;
2. Выбрать "Москва" в поле Выбор офиса обслуживания, если это поле появилось;
3. Ввести в поле "Вывести" значение "один" ;
4. Кликнуть по кнопке "Вывести";

##### Ожидаемый результат: Сообщение об ошибке - "Поле должно содержать только цифры!"
##### Приоритет (Priority) - Medium

**№10 Отправка формы "Вывод средств со счета" используя проценты в поле "Вывести" :**
1. Перейти на страницу https://groall.noda.pro/test_qa;
2. Выбрать "Москва" в поле Выбор офиса обслуживания, если это поле появилось;
3. Ввести в поле "Вывести" значение "50%" ;
4. Кликнуть по кнопке "Вывести";

##### Ожидаемый результат: Сообщение об ошибке - "Поле должно содержать только цифры!"
##### Приоритет (Priority) - Medium

**№11 Отправка формы "Вывод средств со счета" используя отрицательное число в поле "Вывести" :**
1. Перейти на страницу https://groall.noda.pro/test_qa;
2. Выбрать "Москва" в поле Выбор офиса обслуживания, если это поле появилось;
3. Ввести в поле "Вывести" значение "-10" ;
4. Кликнуть по кнопке "Вывести";

##### Ожидаемый результат: Сообщение об ошибке - "Поле должно содержать только цифры!"
##### Приоритет (Priority) - Medium

**№12 Отправка формы "Вывод средств со счета" используя отрицательное число в поле "Вывести" :**
1. Перейти на страницу https://groall.noda.pro/test_qa;
2. Выбрать "Москва" в поле Выбор офиса обслуживания, если это поле появилось;
3. Ввести в поле "Вывести" значение "+10" ;
4. Кликнуть по кнопке "Вывести";

##### Ожидаемый результат: Сообщение об ошибке - "Поле должно содержать только цифры!"
##### Приоритет (Priority) - Medium

**№13 Отправка формы "Вывод средств со счета" используя ноль в поле "Вывести" :**
1. Перейти на страницу https://groall.noda.pro/test_qa;
2. Выбрать "Москва" в поле Выбор офиса обслуживания, если это поле появилось;
3. Ввести в поле "Вывести" значение "0" ;
4. Кликнуть по кнопке "Вывести";

##### Ожидаемый результат: Сообщение об ошибке - "Поле должно содержать значение больше 0"
##### Приоритет (Priority) - Medium

**№14 Отправка формы "Вывод средств со счета" используя используя число больше суммы на счете в поле "Вывести" :**
1. Перейти на страницу https://groall.noda.pro/test_qa;
2. Выбрать "Москва" в поле Выбор офиса обслуживания, если это поле появилось;
3. Ввести в поле "Вывести" значение "1221" ;
4. Кликнуть по кнопке "Вывести";

##### Ожидаемый результат: Сообщение об ошибке - "Значение поля не может быть больше суммы на счете"
##### Приоритет (Priority) - Medium

**№15 Отправка формы "Вывод средств со счета" используя используя число 1 в поле "Вывести" :**
1. Перейти на страницу https://groall.noda.pro/test_qa;
2. Выбрать "Москва" в поле Выбор офиса обслуживания, если это поле появилось;
3. Ввести в поле "Вывести" значение "1" ;
4. Кликнуть по кнопке "Вывести";

##### Ожидаемый результат: Ожидаемый результат: Сообщений ошибках нет. Появляется PopUp с сообщением "Токены списаны, всего списано 100, осталось 121900."Сумма токенов, оставшихся на счете пользователя уменьшилась на 100, на экране показывается "Баланс: 121900 токенов".
##### Приоритет (Priority) - High

**№16 Отправка формы "Вывод средств со счета" используя используя значение 1219.99 в поле "Вывести" :**
1. Перейти на страницу https://groall.noda.pro/test_qa;
2. Выбрать "Москва" в поле Выбор офиса обслуживания, если это поле появилось;
3. Ввести в поле "Вывести" значение "1219.99" ;
4. Кликнуть по кнопке "Вывести";

##### Ожидаемый результат: Ожидаемый результат: Сообщений ошибках нет. Появляется PopUp с сообщением "Токены списаны, всего списано 121999, осталось 1."Сумма токенов, оставшихся на счете пользователя уменьшилась на 121999, на экране показывается "Баланс: 1 токен".
##### Приоритет (Priority) - High

**№17 Отправка формы "Вывод средств со счета" используя максимальное значение в поле "Вывести" :**
1. Перейти на страницу https://groall.noda.pro/test_qa;
2. Выбрать "Москва" в поле Выбор офиса обслуживания, если это поле появилось;
3. Ввести в поле "Вывести" значение "1220" ;
4. Кликнуть по кнопке "Вывести";

##### Ожидаемый результат: Ожидаемый результат: Сообщений ошибках нет. Появляется PopUp с сообщением "Токены списаны, всего списано 122000, осталось 0."Сумма токенов, оставшихся на счете пользователя уменьшилась на 122000, на экране показывается "Баланс: 0 токенов".
##### Приоритет (Priority) - High

**№18 Отправка формы "Вывод средств со счета" используя чек-бокс "Вывести все" :**
1. Перейти на страницу https://groall.noda.pro/test_qa;
2. Выбрать "Москва" в поле Выбор офиса обслуживания, если это поле появилось;
3. Нажать чек-бокс "Вывести все";
4. Кликнуть по кнопке "Вывести";

##### Ожидаемый результат: Ожидаемый результат: Сообщений ошибках нет. Появляется PopUp с сообщением "Токены списаны, всего списано 122000, осталось 0."Сумма токенов, оставшихся на счете пользователя уменьшилась на 122000, на экране показывается "Баланс: 0 токенов".
##### Приоритет (Priority) - High

**№19 Отправка формы "Вывод средств со счета" с использованием разделителя _ в поле "Вывести" :**
1. Перейти на страницу https://groall.noda.pro/test_qa;
2. Выбрать "Москва" в поле Выбор офиса обслуживания, если это поле появилось;
3. Ввести в поле "Вывести" значение "1_000" ;
4. Кликнуть по кнопке "Вывести";

##### Ожидаемый результат: Сообщение об ошибке - "Поле должно содержать только цифры!"
##### Приоритет (Priority) - Medium

**№20 Отправка формы "Вывод средств со счета" с использованием разделителя пробел в поле "Вывести" :**
1. Перейти на страницу https://groall.noda.pro/test_qa;
2. Выбрать "Москва" в поле Выбор офиса обслуживания, если это поле появилось;
3. Ввести в поле "Вывести" значение "1 000" ;
4. Кликнуть по кнопке "Вывести";

##### Ожидаемый результат: Сообщение об ошибке - "Поле должно содержать только цифры!"
##### Приоритет (Priority) - Medium


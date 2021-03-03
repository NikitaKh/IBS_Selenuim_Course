#language: ru

Функционал: Страхование

  Сценарий: Заявка на страхование для путешественников

    Когда Закрытие cookie уведомления

    Когда выбран пункт основного меню "Страхование"
    И выбран пункт вспомогательного меню"Перейти в каталог"
    Тогда выбран вид странования "Страхование для путешественников"

    Тогда заголовок сраницы 'Страхование путешественников' равен - "Страхование путешественников"
    И выполнить нажатие 'Оформить онлайн'

    Когда выбрана сумма страховой защиты - "Минимальная"
    Тогда выполнено нажате на кнопку - "Оформить"

    Когда заполняются поля:
      | Фамилия       |Хвалин|
      | Имя           |Никита|
      | Отчество      |Сергеевич|
      | Пол           |Мужской|
      | Кем выдан     |УФМС РОССИИ|
      | Дата рождения |10.03.1980|
      | Серия         |5515|
      | Номер         |122323|
      | Дата выдачи   |15.05.2015|

    И значения полей равны:
      | Фамилия       | Хвалин      |
      | Имя           | Никита      |
      | Отчество      | Сергеевич   |
      | Дата рождения | 10.03.1980  |
      | Пол           | Мужской     |
      | Серия         | 5515        |
      | Номер         | 122323      |
      | Дата выдачи   | 15.05.2015  |
      | Кем выдан     | УФМС РОССИИ |

    Тогда выполнено нажате на кнопку - "Продолжить"

    И на странице присутствует сообщение об ошибке - "При заполнении данных произошла ошибка"
    И на странице присутствует сообщение об ошибке - "Поле не заполнено"
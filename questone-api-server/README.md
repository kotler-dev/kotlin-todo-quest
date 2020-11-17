
# questone-api-server

Квест #1

Цель: создать API-сервер для будущего приложения.

Ограничения: все данные для начала сохраняются в памяти - фокус на ознакомления с серверным фреймворком.

С чего начать? Выбрать фреймворк: Javalin (немного попроще старт) или Ktor (не сильно сложнее, но более ортодоксально).

Мануал по Javalin: https://javalin.io/documentation#getting-started

Мануал по Ktor: https://ktor.io/docs/quickstart-index.html#hello-world

Для создания JSON предлагаю для начала взять простой Koson: https://github.com/lectra-tech/koson#koson . Позже заиспользуем ортодоксальную сериализацию.

Описание API можно найти тут: https://dector.space/todo-quest/

# Шаги

- В IDEA установить плагин Ktor, создавать проект через Ktor.
- Пример конфига Gradle с картинками https://ktor.io/docs/gradle.html#intellij-create-the-app
- Запуск проекта Ctrl + Shift + F10 (на Виндовс вместо http://0.0.0.0:8080, нужно указывать http://localhost:8080).
- Koson
https://github.com/lectra-tech/koson
Если используется Koson, то в build.gradle в блоке dependencies дописать зависимость implementation("com.lectra:koson:1.0.5").

- Minimal-json
https://github.com/ralfstx/minimal-json
Если используется Minimal-json, то в build.gradle в блоке dependencies дописать зависимость implementation("com.eclipsesource:minimal-json:0.9.5")
- REST запросы: get, post, put, delete.
Ход выполнения практики:
• Установка Git
• Настройка Git (ввод своих данных, а именно имя и адрес электронной почты)
• Установка SSH-ключа
• Форк репозитория KotlinAsFirst2020
• Создаем копию репозитория с GitHub 
$ git clone ‘ссылка'
• Создание upstream-my с форком KotlinAsFirst2021 (моим)
$ git remote add upstream-my ‘ссылка'
$ git fetch upstream-my
$ git merge upstream-my/master 
$ git push origin master
• Создание новой ветки “backport” и перенос на коммитов из KotlinAsFirst2021 (мой)
$ git checkout -b backport
$ git checkout master
$ git rebase backport
• Создание upstream-theirs с форком KotlinAsFirst2021 (напарника)
$ git remote add upstream-theirs ‘ссылка'
$ git fetch  upstream-theirs
$ git merge  upstream-theirs
• Создание новой ветки “имя коллеги”
$ git checkout -b “имя коллеги”
• Перенос на новую ветку коммитов из KotlinAsFirst2021 (коллеги) с исправлением ошибок
$ git config merge.tool vimdiff
$ git config merge.conflictstyle diff3
$ git config mergetool.prompt false
$ git mergetool
$ git cherry-pick 'номер коммита'
$ git mergetool
$ git cherry-pick –continue
• объединить ветки “backport” и  “имя коллеги” с веткой “master”
$ git checkout master
$ git merge Maria
• Создание файла “remotes.txt” через консоль
$ touch remotes.txt
• Скопировать и вставить в данный файл результат команды git remove -v
$ git add remotes.txt
$ git commit -m 'текст'
• Закоммитить файл в ветку “master”
$ git commit -m 'текст'


package ru.job4j.question;

/**
 * https://job4j.ru/profile/exercise/44/task-view/304
 * Это задание сводится к определению разницы между
 * начальным и измененным состояниями множества.
 *
 * Примечание. Два пользователя считаются равными, если у них равны
 * идентификаторы и имена.
 *
 * Необходимо вычислить:
 *
 *  - Сколько добавлено новых пользователей. Добавленным считается
 *  такой пользователь, что ранее его не было в множестве previous, но в
 *  множестве current он есть.
 *
 *  - Сколько изменено пользователей. Изменённым считается объект,
 *  в котором изменилось имя, а id осталось прежним.
 *
 *  - Сколько удалено пользователей. Удаленным считается такой пользователь,
 *  что ранее он был в множестве previous, но теперь в множестве
 *  current его нет.
 *
 * @author AlexSapsay (sapsayalexey@gmail.com)
 * @version 1.0
 * @since 01.11.2021
 */
public class Info {
    private int added;
    private int changed;
    private int deleted;

    public Info(int added, int changed, int deleted) {
        this.added = added;
        this.changed = changed;
        this.deleted = deleted;
    }

    public int getAdded() {
        return added;
    }

    public void setAdded(int added) {
        this.added = added;
    }

    public int getChanged() {
        return changed;
    }

    public void setChanged(int changed) {
        this.changed = changed;
    }

    public int getDeleted() {
        return deleted;
    }

    public void setDeleted(int deleted) {
        this.deleted = deleted;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Info info = (Info) o;

        if (added != info.added) {
            return false;
        }
        if (changed != info.changed) {
            return false;
        }
        return deleted == info.deleted;
    }

    @Override
    public int hashCode() {
        int result = added;
        result = 31 * result + changed;
        result = 31 * result + deleted;
        return result;
    }
}

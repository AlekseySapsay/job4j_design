package ru.job4j.question;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * https://job4j.ru/profile/exercise/44/task-view/304
 * Это задание сводится к определению разницы между
 * начальным и измененным состояниями множества.
 * <p>
 * - Сколько изменено пользователей. Изменённым считается объект,
 * в котором изменилось имя, а id осталось прежним.
 * <p>
 * - Сколько добавлено новых пользователей. Добавленным считается такой
 * пользователь, что ранее его не было в множестве previous, но в
 * множестве current он есть.
 * <p>
 * <p>
 * Сколько удалено пользователей. Удаленным считается такой пользователь,
 * что ранее он был в множестве previous, но теперь в множестве
 * current его нет.
 *
 * @author AlexSapsay (sapsayalexey@gmail.com)
 * @version 1.0
 * @since 31.10.2021
 */
public class Analize {
    public static Info diff(Set<User> previous, Set<User> current) {
        int added = 0;
        int changed = 0;
        int deleted = 0;

        Map<Integer, User> map = new HashMap<>();

        for (User element : previous) {
            map.put(element.getId(), element);
        }
        for (User element : current) {
            User previousUser = map.putIfAbsent(element.getId(), element);
            if (previousUser != null) {
                if (!element.equals(previousUser)) {
                    changed++;
                }
            } else {
                added++;
            }
        }
        deleted = previous.size() - current.size() + added;
        return new Info(added, changed, deleted);
    }
}


//
//        Map<Integer, String> hashMapPrev = new HashMap();
//        for (User user : previous) {
//            hashMapPrev.put(user.getId(), user.getName());
//        }
//
//        /**
//         * map текущих пользователей
//         */
//        Map<Integer, String> hashMapCurrent = new HashMap();
//        for (User user : current) {
//            hashMapCurrent.put(user.getId(), user.getName());
//        }
//
//
//        for (User user : current) {
//            if (hashMapPrev.containsKey(user.getId())
//                    && (!user.getName().equals(hashMapPrev.get(user.getId())))) {
//                changed += 1;
//            }
//        }
//
//        /**
//         *  - Сколько добавлено новых пользователей. Добавленным считается такой
//         *  пользователь, что ранее его не было в множестве previous, но в
//         *  множестве current он есть.
//         */
//        for (User user : current) {
//            if (!previous.contains(user)
//                    && !hashMapPrev.containsKey(user.getId())) {
//                added += 1;
//            }
//        }
//
//        /**
//         *  Сколько удалено пользователей. Удаленным считается такой пользователь,
//         *  что ранее он был в множестве previous, но теперь в множестве
//         *  current его нет.
//         */
//        for (User user : previous) {
//            if (!current.contains(user)
//                    && !hashMapCurrent.containsKey(user.getId())) {
//                deleted += 1;
//            }
//        }
//        return new Info(added, changed, deleted);
//    }
//}

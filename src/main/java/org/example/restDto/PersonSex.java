package org.example.restDto;

/**
 * Пол человека
 */
public enum PersonSex {
    /**
     * Мужской
     */
    MALE,

    /**
     * Женский
     */
    FEMALE;

    /**
     * Возвращает пол человека для модели пользователя
     *
     * @param sex пол человека в JPA репозитории
     * @return null, если пол не указан;
     * PersonSex.MALE если значение пола true;
     * PersonSex.FEMALE если значение пола false;
     */
    public static PersonSex getSex(Boolean sex) {
        if (sex == null) return null;
        return sex ? PersonSex.MALE : PersonSex.FEMALE;
    }
}

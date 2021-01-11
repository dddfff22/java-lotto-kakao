package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {

    public final int LOTTO_NUMBER_COUNT = 6;
    private final List<LottoNumber> lottoNumbers;

    public Lotto(List<LottoNumber> lottoNumbers) {

        if (lottoNumbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("6자리 숫자가 아닙니다.");
        }
        this.lottoNumbers = lottoNumbers;
    }

    public List<LottoNumber> getLottoNumbers() {

        return Collections.unmodifiableList(lottoNumbers);
    }

    public int checkSameCount(Lotto userLotto) {

        int count = 0;
        for (LottoNumber number : userLotto.getLottoNumbers()) {
            count += contain(number);
        }

        return count;
    }

    public int contain(LottoNumber number) {

        if (lottoNumbers.contains(number)) {
            return 1;
        }
        return 0;
    }

    @Override
    public String toString() {

        StringBuilder str = new StringBuilder();
        str.append('[');
        str.append(lottoNumbers.stream().map(Object::toString).collect(Collectors.joining(", ")));
        str.append("]\n");
        return str.toString();
    }

}

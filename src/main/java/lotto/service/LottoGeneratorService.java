package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.util.RandomUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class LottoGeneratorService {
    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final int LOTTO_MAX_INT=45;
    private static final int LOTTO_SMALL_INT=1;
    private static final ArrayList<LottoNumber> lottoSelectors;

    static {
        lottoSelectors=new ArrayList<>();
        for(int i=LOTTO_SMALL_INT;i<=LOTTO_MAX_INT;i++){
            lottoSelectors.add(new LottoNumber(i));
        }
    }


    public Lotto generateLotto() {

        Collections.shuffle(lottoSelectors);
        List<LottoNumber> lottoNumbers = new ArrayList<>();

        for(int i=0;i<LOTTO_NUMBER_COUNT;i++){
            lottoNumbers.add(lottoSelectors.get(i));
        }

        Collections.sort(lottoNumbers);
        return new Lotto(lottoNumbers);
    }


    public Lotto lottoStringParser(String lotto) {

        String[] lottoNumber = lotto.split(",");
        List<LottoNumber> parsedLotto = new ArrayList<>();
        try {
            convertList(lottoNumber, parsedLotto);
            return new Lotto(parsedLotto);
        } catch (Exception e) {
            return null;
        }

    }

    private void convertList(String[] lottoNumber, List<LottoNumber> parsedLotto) {
        for (String number : lottoNumber) {
            parsedLotto.add(new LottoNumber(Integer.parseInt(number.trim())));
        }
    }

}

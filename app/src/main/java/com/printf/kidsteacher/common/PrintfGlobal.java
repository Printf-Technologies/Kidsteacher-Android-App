package com.printf.kidsteacher.common;

import com.printf.kidsteacher.R;
import com.printf.kidsteacher.been.ViewModel;
import com.printf.kidsteacher.been.WriteBeen;

import java.util.ArrayList;

public class PrintfGlobal {
    public static String countryCode;

    public static String getCountryCode() {
        if (countryCode != null && !PrintfGlobal.countryCode.equals("")) {
            return countryCode;
        }
        return "US";
    }

    /********************* Read Start *********************/

    public static ArrayList<ViewModel> getFromAlphabets() {
        ArrayList<ViewModel> data = new ArrayList<>();
        if (!PrintfGlobal.getCountryCode().equalsIgnoreCase("IN")) {
            data.add(new ViewModel(R.drawable.alphabet_apple, R.drawable.background_6, "Apple", R.raw.audio_alphbet_a_us, "A", "a", R.raw.audio_alphbet_info_apple, "#FAFAFA"));
            data.add(new ViewModel(R.drawable.alphabet_ball, R.drawable.background_2, "Ball", R.raw.audio_alphbet_b_us, "B", "b", R.raw.audio_alphbet_info_ball, "#d50000"));
            data.add(new ViewModel(R.drawable.alphabet_cat, R.drawable.background_2, "Cat", R.raw.audio_alphbet_c_us, "C", "c", R.raw.audio_alphbet_info_cat, "#1A237E"));
            data.add(new ViewModel(R.drawable.alphabet_dog, R.drawable.background_2, "Dog", R.raw.audio_alphbet_d_us, "D", "d", R.raw.audio_alphbet_info_dog, "#E65100"));
            data.add(new ViewModel(R.drawable.alphabet_elephant, R.drawable.background_2, "Elephant", R.raw.audio_alphbet_e_us, "E", "e", R.raw.audio_alphbet_info_elephant, "#01579B"));
            data.add(new ViewModel(R.drawable.alphabet_fish, R.drawable.background_3, "Fish", R.raw.audio_alphbet_f_us, "F", "f", R.raw.audio_alphbet_info_fish, "#FF3D00"));
            data.add(new ViewModel(R.drawable.alphabet_got, R.drawable.background_2, "Goat", R.raw.audio_alphbet_g_us, "G", "g", R.raw.audio_alphbet_info_goat, "#D7CCC8"));
            data.add(new ViewModel(R.drawable.alphabet_hourse, R.drawable.background_2, "Horse", R.raw.audio_alphbet_h_us, "H", "h", R.raw.audio_alphbet_info_horse, "#3E2723"));
            data.add(new ViewModel(R.drawable.alphabet_icecreame, R.drawable.background_2, "Ice Cream", R.raw.audio_alphbet_i_us, "I", "i", R.raw.audio_alphbet_info_icecream, "#6D4C41"));
            data.add(new ViewModel(R.drawable.alphabet_jug, R.drawable.background_2, "Jug", R.raw.audio_alphbet_j_us, "J", "j", R.raw.audio_alphbet_info_jug, "#FF5722"));
            data.add(new ViewModel(R.drawable.alphabet_kite, R.drawable.background_2, "Kite", R.raw.audio_alphbet_k_us, "K", "k", R.raw.audio_alphbet_info_kite, "#303F9F"));
            data.add(new ViewModel(R.drawable.alphabet_line, R.drawable.background_2, "Lion", R.raw.audio_alphbet_l_us, "L", "l", R.raw.audio_alphbet_info_lion, "#FF8F00"));
            data.add(new ViewModel(R.drawable.alphabet_monkey, R.drawable.background_2, "Monkey", R.raw.audio_alphbet_m_us, "M", "m", R.raw.audio_alphbet_info_monkey, "#FFA726"));
            data.add(new ViewModel(R.drawable.alphabet_hen, R.drawable.background_2, "Nest", R.raw.audio_alphbet_n_us, "N", "n", R.raw.audio_alphbet_info_nesk, "#FAFAFA"));
            data.add(new ViewModel(R.drawable.alphabet_owl, R.drawable.background_2, "Owl", R.raw.audio_alphbet_o_us, "O", "o", R.raw.audio_alphbet_info_owl, "#3E2723"));
            data.add(new ViewModel(R.drawable.alphabet_parret, R.drawable.background_2, "Parrot", R.raw.audio_alphbet_p_us, "P", "p", R.raw.audio_alphbet_info_parrot, "#FFCA28"));
            data.add(new ViewModel(R.drawable.alphabet_queen, R.drawable.background_2, "Queen", R.raw.audio_alphbet_q_us, "Q", "q", R.raw.audio_alphbet_info_queen, "#D81B60"));
            data.add(new ViewModel(R.drawable.alphabet_rabbit, R.drawable.background_2, "Rabbit", R.raw.audio_alphbet_r_us, "R", "r", R.raw.audio_alphbet_info_rabbit, "#FF5722"));
            data.add(new ViewModel(R.drawable.alphabet_snack, R.drawable.background_2, "Snake", R.raw.audio_alphbet_s_us, "S", "s", R.raw.audio_alphbet_info_snake, "#d50000"));
            data.add(new ViewModel(R.drawable.alphabet_tiger, R.drawable.background_2, "Tiger", R.raw.audio_alphbet_t_us, "T", "t", R.raw.audio_alphbet_info_tiger, "#FF6F00"));
            data.add(new ViewModel(R.drawable.alphabet_umbrella, R.drawable.background_2, "Umbrella", R.raw.audio_alphbet_u_us, "U", "u", R.raw.audio_alphbet_info_umbrella, "#311B92"));
            data.add(new ViewModel(R.drawable.alphabet_van, R.drawable.background_5, "Van", R.raw.audio_alphbet_v_us, "V", "v", R.raw.audio_alphbet_info_van, "#5D4037"));
            data.add(new ViewModel(R.drawable.alphabet_watch, R.drawable.background_5, "Watch", R.raw.audio_alphbet_w_us, "W", "w", R.raw.audio_alphbet_info_watch, "#FAFAFA"));
            data.add(new ViewModel(R.drawable.alphabet_x, R.drawable.background_5, "Xylophone", R.raw.audio_alphbet_x_us, "X", "x", R.raw.audio_alphbet_info_xylophone, "#3E2723"));
            data.add(new ViewModel(R.drawable.alphabet_yark, R.drawable.background_5, "Yak", R.raw.audio_alphbet_y_us, "Y", "y", R.raw.audio_alphbet_info_yellow, "#5D4037"));
            data.add(new ViewModel(R.drawable.alphabet_zebra, R.drawable.background_5, "Zebra", R.raw.audio_alphbet_z_us, "Z", "z", R.raw.audio_alphbet_info_zebra, "#212121"));
        } else {
            data.add(new ViewModel(R.drawable.alphabet_apple, R.drawable.background_6, "Apple", R.raw.audio_alphbet_a, "A", "a", R.raw.audio_alphbet_info_apple, "#FAFAFA"));
            data.add(new ViewModel(R.drawable.alphabet_ball, R.drawable.background_2, "Ball", R.raw.audio_alphbet_b, "B", "b", R.raw.audio_alphbet_info_ball, "#d50000"));
            data.add(new ViewModel(R.drawable.alphabet_cat, R.drawable.background_2, "Cat", R.raw.audio_alphbet_c, "C", "c", R.raw.audio_alphbet_info_cat, "#1A237E"));
            data.add(new ViewModel(R.drawable.alphabet_dog, R.drawable.background_2, "Dog", R.raw.audio_alphbet_d, "D", "d", R.raw.audio_alphbet_info_dog, "#E65100"));
            data.add(new ViewModel(R.drawable.alphabet_elephant, R.drawable.background_2, "Elephant", R.raw.audio_alphbet_e, "E", "e", R.raw.audio_alphbet_info_elephant, "#01579B"));
            data.add(new ViewModel(R.drawable.alphabet_fish, R.drawable.background_3, "Fish", R.raw.audio_alphbet_f, "F", "f", R.raw.audio_alphbet_info_fish, "#FF3D00"));
            data.add(new ViewModel(R.drawable.alphabet_got, R.drawable.background_2, "Goat", R.raw.audio_alphbet_g, "G", "g", R.raw.audio_alphbet_info_goat, "#D7CCC8"));
            data.add(new ViewModel(R.drawable.alphabet_hourse, R.drawable.background_2, "Horse", R.raw.audio_alphbet_h, "H", "h", R.raw.audio_alphbet_info_horse, "#3E2723"));
            data.add(new ViewModel(R.drawable.alphabet_icecreame, R.drawable.background_2, "Ice Cream", R.raw.audio_alphbet_i, "I", "i", R.raw.audio_alphbet_info_icecream, "#6D4C41"));
            data.add(new ViewModel(R.drawable.alphabet_jug, R.drawable.background_2, "Jug", R.raw.audio_alphbet_j, "J", "j", R.raw.audio_alphbet_info_jug, "#FF5722"));
            data.add(new ViewModel(R.drawable.alphabet_kite, R.drawable.background_2, "Kite", R.raw.audio_alphbet_k, "K", "k", R.raw.audio_alphbet_info_kite, "#303F9F"));
            data.add(new ViewModel(R.drawable.alphabet_line, R.drawable.background_2, "Lion", R.raw.audio_alphbet_l, "L", "l", R.raw.audio_alphbet_info_lion, "#FF8F00"));
            data.add(new ViewModel(R.drawable.alphabet_monkey, R.drawable.background_2, "Monkey", R.raw.audio_alphbet_m, "M", "m", R.raw.audio_alphbet_info_monkey, "#FFA726"));
            data.add(new ViewModel(R.drawable.alphabet_hen, R.drawable.background_2, "Nest", R.raw.audio_alphbet_n, "N", "n", R.raw.audio_alphbet_info_nesk, "#FAFAFA"));
            data.add(new ViewModel(R.drawable.alphabet_owl, R.drawable.background_2, "Owl", R.raw.audio_alphbet_o, "O", "o", R.raw.audio_alphbet_info_owl, "#3E2723"));
            data.add(new ViewModel(R.drawable.alphabet_parret, R.drawable.background_2, "Parrot", R.raw.audio_alphbet_p, "P", "p", R.raw.audio_alphbet_info_parrot, "#FFCA28"));
            data.add(new ViewModel(R.drawable.alphabet_queen, R.drawable.background_2, "Queen", R.raw.audio_alphbet_q, "Q", "q", R.raw.audio_alphbet_info_queen, "#D81B60"));
            data.add(new ViewModel(R.drawable.alphabet_rabbit, R.drawable.background_2, "Rabbit", R.raw.audio_alphbet_r, "R", "r", R.raw.audio_alphbet_info_rabbit, "#FF5722"));
            data.add(new ViewModel(R.drawable.alphabet_snack, R.drawable.background_2, "Snake", R.raw.audio_alphbet_s, "S", "s", R.raw.audio_alphbet_info_snake, "#d50000"));
            data.add(new ViewModel(R.drawable.alphabet_tiger, R.drawable.background_2, "Tiger", R.raw.audio_alphbet_t, "T", "t", R.raw.audio_alphbet_info_tiger, "#FF6F00"));
            data.add(new ViewModel(R.drawable.alphabet_umbrella, R.drawable.background_2, "Umbrella", R.raw.audio_alphbet_u, "U", "u", R.raw.audio_alphbet_info_umbrella, "#311B92"));
            data.add(new ViewModel(R.drawable.alphabet_van, R.drawable.background_5, "Van", R.raw.audio_alphbet_v, "V", "v", R.raw.audio_alphbet_info_van, "#5D4037"));
            data.add(new ViewModel(R.drawable.alphabet_watch, R.drawable.background_5, "Watch", R.raw.audio_alphbet_w, "W", "w", R.raw.audio_alphbet_info_watch, "#FAFAFA"));
            data.add(new ViewModel(R.drawable.alphabet_x, R.drawable.background_5, "Xylophone", R.raw.audio_alphbet_x, "X", "x", R.raw.audio_alphbet_info_xylophone, "#3E2723"));
            data.add(new ViewModel(R.drawable.alphabet_yark, R.drawable.background_5, "Yak", R.raw.audio_alphbet_y, "Y", "y", R.raw.audio_alphbet_info_yellow, "#5D4037"));
            data.add(new ViewModel(R.drawable.alphabet_zebra, R.drawable.background_5, "Zebra", R.raw.audio_alphbet_z, "Z", "z", R.raw.audio_alphbet_info_zebra, "#212121"));
        }
        return data;
    }

    public static ArrayList<ViewModel> getFromAnimals() {
        ArrayList<ViewModel> data = new ArrayList<>();
        if (!PrintfGlobal.getCountryCode().equalsIgnoreCase("IN")) {
            data.add(new ViewModel(R.drawable.animal_dog, R.drawable.background_2, "DOG", R.raw.audio_animal_dog_us, R.raw.audio_animal_info_dog, "#3F51B5"));
            data.add(new ViewModel(R.drawable.animal_elephant, R.drawable.background_2, "ELEPHANT", R.raw.audio_animal_elephant_us, R.raw.audio_animal_info_elephant, "#FF5722"));
            data.add(new ViewModel(R.drawable.animal_horse, R.drawable.background_2, "HORSE", R.raw.audio_animal_horse_us, R.raw.audio_animal_info_horse, "#2E7D32"));
            data.add(new ViewModel(R.drawable.animal_cheetah, R.drawable.background_2, "CHEETAH", R.raw.audio_animal_cheetah_us, R.raw.audio_animal_info_cheetah, "#303F9F"));
            data.add(new ViewModel(R.drawable.animal_lion, R.drawable.background_2, "LION", R.raw.audio_animal_lion_us, R.raw.audio_animal_info_lion, "#F4511E"));
            data.add(new ViewModel(R.drawable.animal_tiger, R.drawable.background_2, "TIGER", R.raw.audio_animal_tiger_us, R.raw.audio_animal_info_tiger, "#795548"));
            data.add(new ViewModel(R.drawable.animal_pig, R.drawable.background_2, "PIG", R.raw.audio_animal_pig_us, R.raw.audio_animal_info_pig, "#616161"));
            data.add(new ViewModel(R.drawable.animal_zebra, R.drawable.background_2, "ZEBRA", R.raw.audio_animal_zebra_us, R.raw.audio_animal_info_zebra, "#EC407A"));
            data.add(new ViewModel(R.drawable.animal_dear, R.drawable.background_2, "DEAR", R.raw.audio_animal_dear_us, R.raw.audio_animal_info_dear, "#651FFF"));
            data.add(new ViewModel(R.drawable.animal_donkey, R.drawable.background_2, "DONKEY", R.raw.audio_animal_donkey_us, R.raw.audio_animal_info_donkey, "#FFEB3B"));
            data.add(new ViewModel(R.drawable.animal_sheep, R.drawable.background_2, "SHEEP", R.raw.audio_animal_sheep_us, R.raw.audio_animal_info_sheep, "#6D4C41"));
            data.add(new ViewModel(R.drawable.animal_cat, R.drawable.background_2, "CAT", R.raw.audio_animal_cat_us, R.raw.audio_animal_info_cat, "#1E88E5"));
            data.add(new ViewModel(R.drawable.animal_giraffe, R.drawable.background_2, "GIRAFFE", R.raw.audio_animal_giraffe_us, R.raw.audio_animal_info_giraffe, "#2E7D32"));
            data.add(new ViewModel(R.drawable.animal_hippopotamus, R.drawable.background_4, "HIPPOPOTAMUS", R.raw.audio_animal_hippopotamus_us, R.raw.audio_animal_info_hippopotamus, "#C6FF00"));
            data.add(new ViewModel(R.drawable.animal_caw, R.drawable.background_2, "COW", R.raw.audio_animal_cow_us, R.raw.audio_animal_info_cow, "#FF6F00"));
            data.add(new ViewModel(R.drawable.animal_bear, R.drawable.background_3, "BEAR", R.raw.audio_animal_bear_us, R.raw.audio_animal_info_bear, "#FFFFFF"));
            data.add(new ViewModel(R.drawable.animal_goat, R.drawable.background_2, "GOAT", R.raw.audio_animal_goat_us, R.raw.audio_animal_info_goat, "#6D4C41"));
            data.add(new ViewModel(R.drawable.animal_monkey, R.drawable.background_2, "MONKEY", R.raw.audio_animal_monkey_us, R.raw.audio_animal_info_monkey, "#d32f2f"));
            data.add(new ViewModel(R.drawable.animal_bluewhale, R.drawable.background_3, "BLUE WHALE", R.raw.audio_animal_blue_whale_us, -1, "#FF6F00"));
            data.add(new ViewModel(R.drawable.animal_chimpanzee, R.drawable.background_2, "CHIMPANZEE", R.raw.audio_animal_chimpanzee_us, -1, "#CDDC39"));
            data.add(new ViewModel(R.drawable.animal_crocodile, R.drawable.background_4, "CROCODILE", R.raw.audio_animal_crocodile_us, -1, "#FF5722"));
            data.add(new ViewModel(R.drawable.animal_dolphin, R.drawable.background_4, "DOLPHIN", R.raw.audio_animal_dolphin_us, -1, "#795548"));
            data.add(new ViewModel(R.drawable.animal_fox, R.drawable.background_2, "FOX", R.raw.audio_animal_fox_us, -1, "#607D8B"));
            data.add(new ViewModel(R.drawable.animal_jaguar, R.drawable.background_2, "JAGUAR", R.raw.audio_animal_jaguar_us, -1, "#f44336"));
            data.add(new ViewModel(R.drawable.animal_kangaroo, R.drawable.background_2, "KANGAROO", R.raw.audio_animal_kangaroo_us, -1, "#2196F3"));
            data.add(new ViewModel(R.drawable.animal_killerwhale, R.drawable.background_3, "KILLER WHALE", R.raw.audio_animal_killer_whale_us, -1, "#FF6F00"));
            data.add(new ViewModel(R.drawable.animal_octopus, R.drawable.background_3, "OCTOPUS", R.raw.audio_animal_octopus_us, -1, "#FF9100"));
            data.add(new ViewModel(R.drawable.animal_otter, R.drawable.background_4, "OTTER", R.raw.audio_animal_otter_us, -1, "#FF6F00"));
            data.add(new ViewModel(R.drawable.animal_oyster, R.drawable.background_3, "OYSTER", R.raw.audio_animal_oyster_us, -1, "#DD2C00"));
            data.add(new ViewModel(R.drawable.animal_rabbit, R.drawable.background_2, "RABBIT", R.raw.audio_animal_rabbit_us, -1, "#283593"));
            data.add(new ViewModel(R.drawable.animal_raccoon, R.drawable.background_2, "RACCOON", R.raw.audio_animal_raccoon_us, -1, "#EC407A"));
            data.add(new ViewModel(R.drawable.animal_seaurchin, R.drawable.background_3, "SEA URCHIN", R.raw.audio_animal_sea_urchin_us, -1, "#FFEA00"));
            data.add(new ViewModel(R.drawable.animal_shark, R.drawable.background_3, "SHARK", R.raw.audio_animal_shark_us, -1, "#d50000"));
            data.add(new ViewModel(R.drawable.animal_shells, R.drawable.background_3, "SHELLS", R.raw.audio_animal_shells_us, -1, "#FF3D00"));
            data.add(new ViewModel(R.drawable.animal_snake, R.drawable.background_2, "SNACK", R.raw.audio_animal_snake_us, -1, "#DD2C00"));
        } else {
            data.add(new ViewModel(R.drawable.animal_dog, R.drawable.background_2, "DOG", R.raw.audio_animal_dog, R.raw.audio_animal_info_dog, "#3F51B5"));
            data.add(new ViewModel(R.drawable.animal_elephant, R.drawable.background_2, "ELEPHANT", R.raw.audio_animal_elephant, R.raw.audio_animal_info_elephant, "#FF5722"));
            data.add(new ViewModel(R.drawable.animal_horse, R.drawable.background_2, "HORSE", R.raw.audio_animal_horse, R.raw.audio_animal_info_horse, "#2E7D32"));
            data.add(new ViewModel(R.drawable.animal_cheetah, R.drawable.background_2, "CHEETAH", R.raw.audio_animal_cheetah, R.raw.audio_animal_info_cheetah, "#303F9F"));
            data.add(new ViewModel(R.drawable.animal_lion, R.drawable.background_2, "LION", R.raw.audio_animal_lion, R.raw.audio_animal_info_lion, "#F4511E"));
            data.add(new ViewModel(R.drawable.animal_tiger, R.drawable.background_2, "TIGER", R.raw.audio_animal_tiger, R.raw.audio_animal_info_tiger, "#795548"));
            data.add(new ViewModel(R.drawable.animal_pig, R.drawable.background_2, "PIG", R.raw.audio_animal_pig, R.raw.audio_animal_info_pig, "#616161"));
            data.add(new ViewModel(R.drawable.animal_zebra, R.drawable.background_2, "ZEBRA", R.raw.audio_animal_zebra, R.raw.audio_animal_info_zebra, "#EC407A"));
            data.add(new ViewModel(R.drawable.animal_dear, R.drawable.background_2, "DEAR", R.raw.audio_animal_dear, R.raw.audio_animal_info_dear, "#651FFF"));
            data.add(new ViewModel(R.drawable.animal_donkey, R.drawable.background_2, "DONKEY", R.raw.audio_animal_donkey, R.raw.audio_animal_info_donkey, "#FFEB3B"));
            data.add(new ViewModel(R.drawable.animal_sheep, R.drawable.background_2, "SHEEP", R.raw.audio_animal_sheep, R.raw.audio_animal_info_sheep, "#6D4C41"));
            data.add(new ViewModel(R.drawable.animal_cat, R.drawable.background_2, "CAT", R.raw.audio_animal_cat, R.raw.audio_animal_info_cat, "#1E88E5"));
            data.add(new ViewModel(R.drawable.animal_giraffe, R.drawable.background_2, "GIRAFFE", R.raw.audio_animal_giraffe, R.raw.audio_animal_info_giraffe, "#2E7D32"));
            data.add(new ViewModel(R.drawable.animal_hippopotamus, R.drawable.background_4, "HIPPOPOTAMUS", R.raw.audio_animal_hippopotamus, R.raw.audio_animal_info_hippopotamus, "#C6FF00"));
            data.add(new ViewModel(R.drawable.animal_caw, R.drawable.background_2, "COW", R.raw.audio_animal_cow, R.raw.audio_animal_info_cow, "#FF6F00"));
            data.add(new ViewModel(R.drawable.animal_bear, R.drawable.background_3, "BEAR", R.raw.audio_animal_bear, R.raw.audio_animal_info_bear, "#FFFFFF"));
            data.add(new ViewModel(R.drawable.animal_goat, R.drawable.background_2, "GOAT", R.raw.audio_animal_goat, R.raw.audio_animal_info_goat, "#6D4C41"));
            data.add(new ViewModel(R.drawable.animal_monkey, R.drawable.background_2, "MONKEY", R.raw.audio_animal_monkey, R.raw.audio_animal_info_monkey, "#d32f2f"));
            data.add(new ViewModel(R.drawable.animal_bluewhale, R.drawable.background_3, "BLUE WHALE", R.raw.audio_animal_blue_whale, -1, "#FF6F00"));
            data.add(new ViewModel(R.drawable.animal_chimpanzee, R.drawable.background_2, "CHIMPANZEE", R.raw.audio_animal_chimpanzee, -1, "#CDDC39"));
            data.add(new ViewModel(R.drawable.animal_crocodile, R.drawable.background_4, "CROCODILE", R.raw.audio_animal_crocodile, -1, "#FF5722"));
            data.add(new ViewModel(R.drawable.animal_dolphin, R.drawable.background_4, "DOLPHIN", R.raw.audio_animal_dolphin, -1, "#795548"));
            data.add(new ViewModel(R.drawable.animal_fox, R.drawable.background_2, "FOX", R.raw.audio_animal_fox, -1, "#607D8B"));
            data.add(new ViewModel(R.drawable.animal_jaguar, R.drawable.background_2, "JAGUAR", R.raw.audio_animal_jaguar, -1, "#f44336"));
            data.add(new ViewModel(R.drawable.animal_kangaroo, R.drawable.background_2, "KANGAROO", R.raw.audio_animal_kangaroo, -1, "#2196F3"));
            data.add(new ViewModel(R.drawable.animal_killerwhale, R.drawable.background_3, "KILLER WHALE", R.raw.audio_animal_killer_whale, -1, "#FF6F00"));
            data.add(new ViewModel(R.drawable.animal_octopus, R.drawable.background_3, "OCTOPUS", R.raw.audio_animal_octopus, -1, "#FF9100"));
            data.add(new ViewModel(R.drawable.animal_otter, R.drawable.background_4, "OTTER", R.raw.audio_animal_otter, -1, "#FF6F00"));
            data.add(new ViewModel(R.drawable.animal_oyster, R.drawable.background_3, "OYSTER", R.raw.audio_animal_oyster, -1, "#DD2C00"));
            data.add(new ViewModel(R.drawable.animal_rabbit, R.drawable.background_2, "RABBIT", R.raw.audio_animal_rabbit, -1, "#283593"));
            data.add(new ViewModel(R.drawable.animal_raccoon, R.drawable.background_2, "RACCOON", R.raw.audio_animal_raccoon, -1, "#EC407A"));
            data.add(new ViewModel(R.drawable.animal_seaurchin, R.drawable.background_3, "SEA URCHIN", R.raw.audio_animal_sea_urchin, -1, "#FFEA00"));
            data.add(new ViewModel(R.drawable.animal_shark, R.drawable.background_3, "SHARK", R.raw.audio_animal_shark, -1, "#d50000"));
            data.add(new ViewModel(R.drawable.animal_shells, R.drawable.background_3, "SHELLS", R.raw.audio_animal_shells, -1, "#FF3D00"));
            data.add(new ViewModel(R.drawable.animal_snake, R.drawable.background_2, "SNACK", R.raw.audio_animal_snake, -1, "#DD2C00"));
        }
        return data;
    }

    public static ArrayList<ViewModel> getFromBirds() {
        ArrayList<ViewModel> data = new ArrayList<>();
        if (!PrintfGlobal.getCountryCode().equalsIgnoreCase("IN")) {
            data.add(new ViewModel(R.drawable.bird_albatross, R.drawable.background_4, "ALBATROSS", R.raw.audio_bird_albatross_us, "#FF5722"));
            data.add(new ViewModel(R.drawable.bird_bulbul, R.drawable.background_4, "BULBUL", R.raw.audio_bird_bulbul_us, "#FFC107"));
            data.add(new ViewModel(R.drawable.bird_cormorant, R.drawable.background_4, "CORMORANT", R.raw.audio_bird_cormorant_us, "#00B0FF"));
            data.add(new ViewModel(R.drawable.bird_duks, R.drawable.background_4, "DUCK", R.raw.audio_bird_duks_us, "#3D5AFE"));
            data.add(new ViewModel(R.drawable.bird_finches, R.drawable.background_4, "FINCHES", R.raw.audio_bird_finches_us, "#E040FB"));
            data.add(new ViewModel(R.drawable.bird_fowl, R.drawable.background_2, "FOWL", R.raw.audio_bird_fowl_us, "#FDD835"));
            data.add(new ViewModel(R.drawable.bird_goose, R.drawable.background_4, "GOOSE", R.raw.audio_bird_goose_us, "#EEFF41"));
            data.add(new ViewModel(R.drawable.bird_heron, R.drawable.background_4, "HERON", R.raw.audio_bird_heron_us, "#64DD17"));
            data.add(new ViewModel(R.drawable.bird_hornbill, R.drawable.background_4, "HORNBILL", R.raw.audio_bird_hornbill_us, "#651FFF"));
            data.add(new ViewModel(R.drawable.bird_hummingbird, R.drawable.background_2, "HUMMINGBIRD", R.raw.audio_bird_hummingbird_us, "#FF4081"));
            data.add(new ViewModel(R.drawable.bird_kingfisher, R.drawable.background_2, "KINGFISHER", R.raw.audio_bird_kingfisher_us, "#F48FB1"));
            data.add(new ViewModel(R.drawable.bird_lbis, R.drawable.background_4, "IBIS", R.raw.audio_bird_lbis_us, "#FFAB91"));
            data.add(new ViewModel(R.drawable.bird_moa, R.drawable.background_2, "MOA", R.raw.audio_bird_moa_us, "#FFB74D"));
            data.add(new ViewModel(R.drawable.bird_owl, R.drawable.background_2, "OWL", R.raw.audio_bird_owl_us, "#FF6F00"));
            data.add(new ViewModel(R.drawable.bird_paradise, R.drawable.background_4, "BIRD OF PARADISE", R.raw.audio_bird_paradise_us, "#6200EA"));
            data.add(new ViewModel(R.drawable.bird_parrot, R.drawable.background_2, "PARROT", R.raw.audio_bird_parrot_us, "#f44336"));
            data.add(new ViewModel(R.drawable.bird_pigeons_and_doves, R.drawable.background_2, "DOVE", R.raw.audio_bird_doves_us, "#2196F3"));
        } else {
            data.add(new ViewModel(R.drawable.bird_albatross, R.drawable.background_4, "ALBATROSS", R.raw.audio_bird_albatross, "#FF5722"));
            data.add(new ViewModel(R.drawable.bird_bulbul, R.drawable.background_4, "BULBUL", R.raw.audio_bird_bulbul, "#FFC107"));
            data.add(new ViewModel(R.drawable.bird_cormorant, R.drawable.background_4, "CORMORANT", R.raw.audio_bird_cormorant, "#00B0FF"));
            data.add(new ViewModel(R.drawable.bird_duks, R.drawable.background_4, "DUCK", R.raw.audio_bird_duks, "#3D5AFE"));
            data.add(new ViewModel(R.drawable.bird_finches, R.drawable.background_4, "FINCHES", R.raw.audio_bird_finches, "#E040FB"));
            data.add(new ViewModel(R.drawable.bird_fowl, R.drawable.background_2, "FOWL", R.raw.audio_bird_fowl, "#FDD835"));
            data.add(new ViewModel(R.drawable.bird_goose, R.drawable.background_4, "GOOSE", R.raw.audio_bird_goose, "#EEFF41"));
            data.add(new ViewModel(R.drawable.bird_heron, R.drawable.background_4, "HERON", R.raw.audio_bird_heron, "#64DD17"));
            data.add(new ViewModel(R.drawable.bird_hornbill, R.drawable.background_4, "HORNBILL", R.raw.audio_bird_hornbill, "#651FFF"));
            data.add(new ViewModel(R.drawable.bird_hummingbird, R.drawable.background_2, "HUMMINGBIRD", R.raw.audio_bird_hummingbird, "#FF4081"));
            data.add(new ViewModel(R.drawable.bird_kingfisher, R.drawable.background_2, "KINGFISHER", R.raw.audio_bird_kingfisher, "#F48FB1"));
            data.add(new ViewModel(R.drawable.bird_lbis, R.drawable.background_4, "IBIS", R.raw.audio_bird_lbis, "#FFAB91"));
            data.add(new ViewModel(R.drawable.bird_moa, R.drawable.background_2, "MOA", R.raw.audio_bird_moa, "#FFB74D"));
            data.add(new ViewModel(R.drawable.bird_owl, R.drawable.background_2, "OWL", R.raw.audio_bird_owl, "#FF6F00"));
            data.add(new ViewModel(R.drawable.bird_paradise, R.drawable.background_4, "BIRD OF PARADISE", R.raw.audio_bird_paradise, "#6200EA"));
            data.add(new ViewModel(R.drawable.bird_parrot, R.drawable.background_2, "PARROT", R.raw.audio_bird_parrot, "#f44336"));
            data.add(new ViewModel(R.drawable.bird_pigeons_and_doves, R.drawable.background_2, "DOVE", R.raw.audio_bird_doves, "#2196F3"));
        }
        return data;
    }

    public static ArrayList<ViewModel> getFromBodyParts() {
        ArrayList<ViewModel> data = new ArrayList<>();
        if (!PrintfGlobal.getCountryCode().equalsIgnoreCase("IN")) {
            data.add(new ViewModel(R.drawable.body_hair, R.drawable.background_7, "HAIR", R.raw.audio_body_hair_us, "#90CAF9"));
            data.add(new ViewModel(R.drawable.body_eye, R.drawable.background_7, "EYE", R.raw.audio_body_eye_us, "#EC407A"));
            data.add(new ViewModel(R.drawable.body_hend, R.drawable.background_7, "HAND", R.raw.audio_body_hand_us, "#D500F9"));
            data.add(new ViewModel(R.drawable.body_ear, R.drawable.background_7, "EAR", R.raw.audio_body_ear_us, "#FF3D00"));
            data.add(new ViewModel(R.drawable.body_lips, R.drawable.background_7, "LIP", R.raw.audio_body_lips_us, "#F4511E"));
            data.add(new ViewModel(R.drawable.body_nose, R.drawable.background_7, "NOSE", R.raw.audio_body_nose_us, "#5D4037"));
            data.add(new ViewModel(R.drawable.body_arm, R.drawable.background_7, "ARM", R.raw.audio_body_arm_us, "#FF6D00"));
            data.add(new ViewModel(R.drawable.body_foot, R.drawable.background_7, "FOOT", R.raw.audio_body_foot_us, "#FFC400"));
            data.add(new ViewModel(R.drawable.body_shoulders, R.drawable.background_7, "SHOULDER", R.raw.audio_body_shoulders_us, "#E040FB"));
            data.add(new ViewModel(R.drawable.body_finger, R.drawable.background_7, "FINGER", R.raw.audio_body_finger_us, "#c62828"));
            data.add(new ViewModel(R.drawable.body_mounth, R.drawable.background_7, "MOUTH", R.raw.audio_body_mouth_us, "#283593"));
            data.add(new ViewModel(R.drawable.body_leg, R.drawable.background_7, "LEG", R.raw.audio_body_leg_us, "#F4511E"));
            data.add(new ViewModel(R.drawable.body_stomach, R.drawable.background_7, "STOMACH", R.raw.audio_body_stomach_us, "#FFE082"));
            data.add(new ViewModel(R.drawable.body_tongue, R.drawable.background_7, "TONGUE", R.raw.audio_body_tongue_us, "#FFF9C4"));
        } else {
            data.add(new ViewModel(R.drawable.body_hair, R.drawable.background_7, "HAIR", R.raw.audio_body_hair, "#90CAF9"));
            data.add(new ViewModel(R.drawable.body_eye, R.drawable.background_7, "EYE", R.raw.audio_body_eye, "#EC407A"));
            data.add(new ViewModel(R.drawable.body_hend, R.drawable.background_7, "HAND", R.raw.audio_body_hand, "#D500F9"));
            data.add(new ViewModel(R.drawable.body_ear, R.drawable.background_7, "EAR", R.raw.audio_body_ear, "#FF3D00"));
            data.add(new ViewModel(R.drawable.body_lips, R.drawable.background_7, "LIP", R.raw.audio_body_lips, "#F4511E"));
            data.add(new ViewModel(R.drawable.body_nose, R.drawable.background_7, "NOSE", R.raw.audio_body_nose, "#5D4037"));
            data.add(new ViewModel(R.drawable.body_arm, R.drawable.background_7, "ARM", R.raw.audio_body_arm, "#FF6D00"));
            data.add(new ViewModel(R.drawable.body_foot, R.drawable.background_7, "FOOT", R.raw.audio_body_foot, "#FFC400"));
            data.add(new ViewModel(R.drawable.body_shoulders, R.drawable.background_7, "SHOULDER", R.raw.audio_body_shoulders, "#E040FB"));
            data.add(new ViewModel(R.drawable.body_finger, R.drawable.background_7, "FINGER", R.raw.audio_body_finger, "#c62828"));
            data.add(new ViewModel(R.drawable.body_mounth, R.drawable.background_7, "MOUTH", R.raw.audio_body_mouth, "#283593"));
            data.add(new ViewModel(R.drawable.body_leg, R.drawable.background_7, "LEG", R.raw.audio_body_leg, "#F4511E"));
            data.add(new ViewModel(R.drawable.body_stomach, R.drawable.background_7, "STOMACH", R.raw.audio_body_stomach, "#FFE082"));
            data.add(new ViewModel(R.drawable.body_tongue, R.drawable.background_7, "TONGUE", R.raw.audio_body_tongue, "#FFF9C4"));
        }
        return data;
    }

    public static ArrayList<ViewModel> getFromBuilding() {
        ArrayList<ViewModel> data = new ArrayList<>();
        if (!PrintfGlobal.getCountryCode().equalsIgnoreCase("IN")) {
            data.add(new ViewModel(R.drawable.building_bus_station, R.drawable.background_2, "BUS STATION", R.raw.audio_building_bus_station_us, "#00E676"));
            data.add(new ViewModel(R.drawable.building_fire_station, R.drawable.background_2, "FIRE STATION", R.raw.audio_building_fire_station_us, "#D500F9"));
            data.add(new ViewModel(R.drawable.building_flat, R.drawable.background_2, "FLAT", R.raw.audio_building_flat_us, "#f44336"));
            data.add(new ViewModel(R.drawable.building_hospital, R.drawable.background_2, "HOSPITAL", R.raw.audio_building_hospital_us, "#EDE7F6"));
            data.add(new ViewModel(R.drawable.building_house, R.drawable.background_2, "HOUSE", R.raw.audio_building_house_us, "#8BC34A"));
            data.add(new ViewModel(R.drawable.building_police_station, R.drawable.background_2, "POLICE STATION", R.raw.audio_building_police_station_us, "#F4511E"));
            data.add(new ViewModel(R.drawable.building_train_station, R.drawable.background_2, "TRAIN STATION", R.raw.audio_building_railway_station_us, "#7CB342"));
        } else {
            data.add(new ViewModel(R.drawable.building_bus_station, R.drawable.background_2, "BUS STATION", R.raw.audio_building_bus_station, "#00E676"));
            data.add(new ViewModel(R.drawable.building_fire_station, R.drawable.background_2, "FIRE STATION", R.raw.audio_building_fire_station, "#D500F9"));
            data.add(new ViewModel(R.drawable.building_flat, R.drawable.background_2, "FLAT", R.raw.audio_building_flat, "#f44336"));
            data.add(new ViewModel(R.drawable.building_hospital, R.drawable.background_2, "HOSPITAL", R.raw.audio_building_hospital, "#EDE7F6"));
            data.add(new ViewModel(R.drawable.building_house, R.drawable.background_2, "HOUSE", R.raw.audio_building_house, "#8BC34A"));
            data.add(new ViewModel(R.drawable.building_police_station, R.drawable.background_2, "POLICE STATION", R.raw.audio_building_police_station, "#F4511E"));
            data.add(new ViewModel(R.drawable.building_train_station, R.drawable.background_2, "TRAIN STATION", R.raw.audio_building_railway_station, "#7CB342"));
        }
        return data;
    }

    public static ArrayList<ViewModel> getFromColors() {
        ArrayList<ViewModel> data = new ArrayList<>();
        if (!PrintfGlobal.getCountryCode().equalsIgnoreCase("IN")) {
            data.add(new ViewModel(R.drawable.color_red, R.drawable.background_2, "RED", R.raw.audio_color_red_us, "#e51400"));
            data.add(new ViewModel(R.drawable.color_yellow, R.drawable.background_2, "YELLOW", R.raw.audio_color_yellow_us, "#e3c800"));
            data.add(new ViewModel(R.drawable.color_orange, R.drawable.background_2, "ORANGE", R.raw.audio_color_orange_us, "#FF9800"));
            data.add(new ViewModel(R.drawable.color_green, R.drawable.background_2, "GREEN", R.raw.audio_color_green_us, "#60a917"));
            data.add(new ViewModel(R.drawable.color_blue, R.drawable.background_2, "BLUE", R.raw.audio_color_blue_us, "#2196F3"));
            data.add(new ViewModel(R.drawable.color_black, R.drawable.background_2, "BLACK", R.raw.audio_color_black_us, "#000000"));
            data.add(new ViewModel(R.drawable.color_pink, R.drawable.background_2, "PINK", R.raw.audio_color_pink_us, "#E91E63"));
        } else {
            data.add(new ViewModel(R.drawable.color_red, R.drawable.background_2, "RED", R.raw.audio_color_red, "#e51400"));
            data.add(new ViewModel(R.drawable.color_yellow, R.drawable.background_2, "YELLOW", R.raw.audio_color_yellow, "#e3c800"));
            data.add(new ViewModel(R.drawable.color_orange, R.drawable.background_2, "ORANGE", R.raw.audio_color_orange, "#FF9800"));
            data.add(new ViewModel(R.drawable.color_green, R.drawable.background_2, "GREEN", R.raw.audio_color_green, "#60a917"));
            data.add(new ViewModel(R.drawable.color_blue, R.drawable.background_2, "BLUE", R.raw.audio_color_blue, "#2196F3"));
            data.add(new ViewModel(R.drawable.color_black, R.drawable.background_2, "BLACK", R.raw.audio_color_black, "#000000"));
            data.add(new ViewModel(R.drawable.color_pink, R.drawable.background_2, "PINK", R.raw.audio_color_pink, "#E91E63"));
        }
        return data;
    }

    public static ArrayList<ViewModel> getFromDays() {
        ArrayList<ViewModel> data = new ArrayList<>();
        if (!PrintfGlobal.getCountryCode().equalsIgnoreCase("IN")) {
            data.add(new ViewModel(R.drawable.day_monday, R.drawable.background_3, "", R.raw.audio_day_monday_us, "#FF9800"));
            data.add(new ViewModel(R.drawable.day_tuesday, R.drawable.background_3, "", R.raw.audio_day_tuesday_us, "#CDDC39"));
            data.add(new ViewModel(R.drawable.day_wednesday, R.drawable.background_3, "", R.raw.audio_day_wednesday_us, "#00BCD4"));
            data.add(new ViewModel(R.drawable.day_thursday, R.drawable.background_3, "", R.raw.audio_day_thursday_us, "#FFB74D"));
            data.add(new ViewModel(R.drawable.day_friday, R.drawable.background_3, "", R.raw.audio_day_friday_us, "#1E88E5"));
            data.add(new ViewModel(R.drawable.day_saturday, R.drawable.background_3, "", R.raw.audio_day_saturday_us, "#009688"));
            data.add(new ViewModel(R.drawable.day_sunday, R.drawable.background_3, "", R.raw.audio_day_sunday_us, "#1DE9B6"));
        } else {
            data.add(new ViewModel(R.drawable.day_monday, R.drawable.background_3, "", R.raw.audio_day_monday, "#FF9800"));
            data.add(new ViewModel(R.drawable.day_tuesday, R.drawable.background_3, "", R.raw.audio_day_tuesday, "#CDDC39"));
            data.add(new ViewModel(R.drawable.day_wednesday, R.drawable.background_3, "", R.raw.audio_day_wednesday, "#00BCD4"));
            data.add(new ViewModel(R.drawable.day_thursday, R.drawable.background_3, "", R.raw.audio_day_thursday, "#FFB74D"));
            data.add(new ViewModel(R.drawable.day_friday, R.drawable.background_3, "", R.raw.audio_day_friday, "#1E88E5"));
            data.add(new ViewModel(R.drawable.day_saturday, R.drawable.background_3, "", R.raw.audio_day_saturday, "#009688"));
            data.add(new ViewModel(R.drawable.day_sunday, R.drawable.background_3, "", R.raw.audio_day_sunday, "#1DE9B6"));
        }
        return data;
    }

    public static ArrayList<ViewModel> getFromFlower() {
        ArrayList<ViewModel> data = new ArrayList<>();
        if (!PrintfGlobal.getCountryCode().equalsIgnoreCase("IN")) {
            data.add(new ViewModel(R.drawable.flower_amaryllis, R.drawable.background_5, "AMARYLLIS", R.raw.audio_flower_amaryllis_us, "#d50000"));
            data.add(new ViewModel(R.drawable.flower_bellflowers, R.drawable.background_5, "BELL FLOWERS", R.raw.audio_flower_bellflowers_us, "#FF6D00"));
            data.add(new ViewModel(R.drawable.flower_crocus, R.drawable.background_5, "CROCUS", R.raw.audio_flower_crocus_us, "#673AB7"));
            data.add(new ViewModel(R.drawable.flower_golden_rayed_lily, R.drawable.background_5, "GOLDEN RAYED LILY", R.raw.audio_flower_golden_rayed_lily_us, "#e57373"));
            data.add(new ViewModel(R.drawable.flower_jasmine, R.drawable.background_5, "JASMINE", R.raw.audio_flower_jasmine_us, "#EC407A"));
            data.add(new ViewModel(R.drawable.flower_marigold, R.drawable.background_5, "MARIGOLD", R.raw.audio_flower_marigold_us, "#7E57C2"));
            data.add(new ViewModel(R.drawable.flower_rose, R.drawable.background_5, "ROSE", R.raw.audio_flower_rose_us, "#5C6BC0"));
            data.add(new ViewModel(R.drawable.flower_sun_flowers, R.drawable.background_5, "SUN FLOWER", R.raw.audio_flower_sun_flowers_us, "#FFD600"));
        } else {
            data.add(new ViewModel(R.drawable.flower_amaryllis, R.drawable.background_5, "AMARYLLIS", R.raw.audio_flower_amaryllis, "#d50000"));
            data.add(new ViewModel(R.drawable.flower_bellflowers, R.drawable.background_5, "BELL FLOWERS", R.raw.audio_flower_bellflowers, "#FF6D00"));
            data.add(new ViewModel(R.drawable.flower_crocus, R.drawable.background_5, "CROCUS", R.raw.audio_flower_crocus, "#673AB7"));
            data.add(new ViewModel(R.drawable.flower_golden_rayed_lily, R.drawable.background_5, "GOLDEN RAYED LILY", R.raw.audio_flower_golden_rayed_lily, "#e57373"));
            data.add(new ViewModel(R.drawable.flower_jasmine, R.drawable.background_5, "JASMINE", R.raw.audio_flower_jasmine, "#EC407A"));
            data.add(new ViewModel(R.drawable.flower_marigold, R.drawable.background_5, "MARIGOLD", R.raw.audio_flower_marigold, "#7E57C2"));
            data.add(new ViewModel(R.drawable.flower_rose, R.drawable.background_5, "ROSE", R.raw.audio_flower_rose, "#5C6BC0"));
            data.add(new ViewModel(R.drawable.flower_sun_flowers, R.drawable.background_5, "SUN FLOWER", R.raw.audio_flower_sun_flowers, "#FFD600"));
        }
        return data;
    }

    public static ArrayList<ViewModel> getFromFruits() {
        ArrayList<ViewModel> data = new ArrayList<>();
        if (!PrintfGlobal.getCountryCode().equalsIgnoreCase("IN")) {
            data.add(new ViewModel(R.drawable.fruit_apple, R.drawable.background_1, "APPLE", R.raw.audio_fruit_apple_us, "#FF6F00"));
            data.add(new ViewModel(R.drawable.fruit_banana, R.drawable.background_1, "BANANA", R.raw.audio_fruit_banana_us, "#EF6C00"));
            data.add(new ViewModel(R.drawable.fruit_avocado, R.drawable.background_1, "AVOCADO", R.raw.audio_fruit_avocado_us, "#8D6E63"));
            data.add(new ViewModel(R.drawable.fruit_mango, R.drawable.background_1, "MANGO", R.raw.audio_fruit_mango_us, "#AB47BC"));
            data.add(new ViewModel(R.drawable.fruit_orange, R.drawable.background_1, "ORANGE", R.raw.audio_color_orange_us, "#f44336"));
            data.add(new ViewModel(R.drawable.fruit_strawberry, R.drawable.background_1, "STRAWBERRY", R.raw.audio_fruit_strawberry_us, "#F57F17"));
            data.add(new ViewModel(R.drawable.fruit_watermelon, R.drawable.background_1, "WATERMELON", R.raw.audio_fruit_watermelon_us, "#F50057"));
            data.add(new ViewModel(R.drawable.fruit_balckberry, R.drawable.background_1, "BLACKBERRY", R.raw.audio_fruit_balck_berry_us, "#FF5722"));
            data.add(new ViewModel(R.drawable.fruit_coconut, R.drawable.background_1, "COCONUT", R.raw.audio_fruit_coconut_us, "#76FF03"));
            data.add(new ViewModel(R.drawable.fruit_guava, R.drawable.background_1, "GUAVA", R.raw.audio_fruit_guava_us, "#00796B"));
            data.add(new ViewModel(R.drawable.fruit_lemon, R.drawable.background_1, "LEMON", R.raw.audio_fruit_lemon_us, "#3F51B5"));
            data.add(new ViewModel(R.drawable.fruit_papaya, R.drawable.background_1, "PAPAYA", R.raw.audio_fruit_papaya_us, "#FFEB3B"));
            data.add(new ViewModel(R.drawable.fruit_pinaple, R.drawable.background_1, "PINEAPPLE", R.raw.audio_fruit_pineapple_us, "#795548"));
            data.add(new ViewModel(R.drawable.fruit_star, R.drawable.background_1, "STAR FRUIT", R.raw.audio_fruit_star_fruit_us, "#e53935"));
            data.add(new ViewModel(R.drawable.fruit_sugar_apple, R.drawable.background_1, "SUGAR APPLE", R.raw.audio_fruit_sugar_apple_us, "#4CAF50"));
        } else {
            data.add(new ViewModel(R.drawable.fruit_apple, R.drawable.background_1, "APPLE", R.raw.audio_fruit_apple, "#FF6F00"));
            data.add(new ViewModel(R.drawable.fruit_banana, R.drawable.background_1, "BANANA", R.raw.audio_fruit_banana, "#EF6C00"));
            data.add(new ViewModel(R.drawable.fruit_avocado, R.drawable.background_1, "AVOCADO", R.raw.audio_fruit_avocado, "#8D6E63"));
            data.add(new ViewModel(R.drawable.fruit_mango, R.drawable.background_1, "MANGO", R.raw.audio_fruit_mango, "#AB47BC"));
            data.add(new ViewModel(R.drawable.fruit_orange, R.drawable.background_1, "ORANGE", R.raw.audio_color_orange, "#f44336"));
            data.add(new ViewModel(R.drawable.fruit_strawberry, R.drawable.background_1, "STRAWBERRY", R.raw.audio_fruit_strawberry, "#F57F17"));
            data.add(new ViewModel(R.drawable.fruit_watermelon, R.drawable.background_1, "WATERMELON", R.raw.audio_fruit_watermelon, "#F50057"));
            data.add(new ViewModel(R.drawable.fruit_balckberry, R.drawable.background_1, "BLACKBERRY", R.raw.audio_fruit_balck_berry, "#FF5722"));
            data.add(new ViewModel(R.drawable.fruit_coconut, R.drawable.background_1, "COCONUT", R.raw.audio_fruit_coconut, "#76FF03"));
            data.add(new ViewModel(R.drawable.fruit_guava, R.drawable.background_1, "GUAVA", R.raw.audio_fruit_guava, "#00796B"));
            data.add(new ViewModel(R.drawable.fruit_lemon, R.drawable.background_1, "LEMON", R.raw.audio_fruit_lemon, "#3F51B5"));
            data.add(new ViewModel(R.drawable.fruit_papaya, R.drawable.background_1, "PAPAYA", R.raw.audio_fruit_papaya, "#FFEB3B"));
            data.add(new ViewModel(R.drawable.fruit_pinaple, R.drawable.background_1, "PINEAPPLE", R.raw.audio_fruit_pineapple, "#795548"));
            data.add(new ViewModel(R.drawable.fruit_star, R.drawable.background_1, "STAR FRUIT", R.raw.audio_fruit_star_fruit, "#e53935"));
            data.add(new ViewModel(R.drawable.fruit_sugar_apple, R.drawable.background_1, "SUGAR APPLE", R.raw.audio_fruit_sugar_apple, "#4CAF50"));
        }
        return data;
    }

    public static ArrayList<ViewModel> getFromMonths() {
        ArrayList<ViewModel> data = new ArrayList<>();
        if (!PrintfGlobal.getCountryCode().equalsIgnoreCase("IN")) {
            data.add(new ViewModel(R.drawable.month_january, R.drawable.background_3, "", R.raw.audio_month_january_us, "#FFA726"));
            data.add(new ViewModel(R.drawable.month_february, R.drawable.background_3, "", R.raw.audio_month_february_us, "#FAFAFA"));
            data.add(new ViewModel(R.drawable.month_march, R.drawable.background_3, "", R.raw.audio_month_march_us, "#5D4037"));
            data.add(new ViewModel(R.drawable.month_april, R.drawable.background_3, "", R.raw.audio_month_april_us, "#3E2723"));
            data.add(new ViewModel(R.drawable.month_may, R.drawable.background_3, "", R.raw.audio_month_may_us, "#303F9F"));
            data.add(new ViewModel(R.drawable.month_june, R.drawable.background_3, "", R.raw.audio_month_jun_us, "#FF6F00"));
            data.add(new ViewModel(R.drawable.month_july, R.drawable.background_3, "", R.raw.audio_month_july_us, "#303F9F"));
            data.add(new ViewModel(R.drawable.month_august, R.drawable.background_3, "", R.raw.audio_month_august_us, "#7CB342"));
            data.add(new ViewModel(R.drawable.month_september, R.drawable.background_3, "", R.raw.audio_month_september_us, "#303F9F"));
            data.add(new ViewModel(R.drawable.month_october, R.drawable.background_3, "", R.raw.audio_month_october_us, "#AB47BC"));
            data.add(new ViewModel(R.drawable.month_november, R.drawable.background_3, "", R.raw.audio_month_november_us, "#ff1744"));
            data.add(new ViewModel(R.drawable.month_december, R.drawable.background_3, "", R.raw.audio_month_december_us, "#F4511E"));
        } else {
            data.add(new ViewModel(R.drawable.month_january, R.drawable.background_3, "", R.raw.audio_month_january, "#FFA726"));
            data.add(new ViewModel(R.drawable.month_february, R.drawable.background_3, "", R.raw.audio_month_february, "#FAFAFA"));
            data.add(new ViewModel(R.drawable.month_march, R.drawable.background_3, "", R.raw.audio_month_march, "#5D4037"));
            data.add(new ViewModel(R.drawable.month_april, R.drawable.background_3, "", R.raw.audio_month_april, "#3E2723"));
            data.add(new ViewModel(R.drawable.month_may, R.drawable.background_3, "", R.raw.audio_month_may, "#303F9F"));
            data.add(new ViewModel(R.drawable.month_june, R.drawable.background_3, "", R.raw.audio_month_jun, "#FF6F00"));
            data.add(new ViewModel(R.drawable.month_july, R.drawable.background_3, "", R.raw.audio_month_july, "#303F9F"));
            data.add(new ViewModel(R.drawable.month_august, R.drawable.background_3, "", R.raw.audio_month_august, "#7CB342"));
            data.add(new ViewModel(R.drawable.month_september, R.drawable.background_3, "", R.raw.audio_month_september, "#303F9F"));
            data.add(new ViewModel(R.drawable.month_october, R.drawable.background_3, "", R.raw.audio_month_october, "#AB47BC"));
            data.add(new ViewModel(R.drawable.month_november, R.drawable.background_3, "", R.raw.audio_month_november, "#ff1744"));
            data.add(new ViewModel(R.drawable.month_december, R.drawable.background_3, "", R.raw.audio_month_december, "#F4511E"));
        }
        return data;
    }

    public static ArrayList<ViewModel> getFromNumbers() {
        ArrayList<ViewModel> data = new ArrayList<>();
        if (!PrintfGlobal.getCountryCode().equalsIgnoreCase("IN")) {
            data.add(new ViewModel(R.drawable.number_01, R.drawable.background_4, "ONE", R.raw.audio_number_one_us, "#FAFAFA"));
            data.add(new ViewModel(R.drawable.number_02, R.drawable.background_4, "TWO", R.raw.audio_number_two_us, "#5D4037"));
            data.add(new ViewModel(R.drawable.number_03, R.drawable.background_4, "THREE", R.raw.audio_number_three_us, "#3E2723"));
            data.add(new ViewModel(R.drawable.number_04, R.drawable.background_4, "FOUR", R.raw.audio_number_four_us, "#FF6F00"));
            data.add(new ViewModel(R.drawable.number_05, R.drawable.background_4, "FIVE", R.raw.audio_number_five_us, "#FF5722"));
            data.add(new ViewModel(R.drawable.number_06, R.drawable.background_4, "SIX", R.raw.audio_number_six_us, "#3E2723"));
            data.add(new ViewModel(R.drawable.number_07, R.drawable.background_4, "SEVEN", R.raw.audio_number_seven_us, "#303F9F"));
            data.add(new ViewModel(R.drawable.number_08, R.drawable.background_4, "EIGHT", R.raw.audio_number_eight_us, "#FFA726"));
            data.add(new ViewModel(R.drawable.number_09, R.drawable.background_4, "NINE", R.raw.audio_number_nine_us, "#FF8F00"));
            data.add(new ViewModel(R.drawable.number_10, R.drawable.background_4, "TEN", R.raw.audio_number_ten_us, "#303F9F"));
        } else {
            data.add(new ViewModel(R.drawable.number_01, R.drawable.background_4, "ONE", R.raw.audio_number_one, "#FAFAFA"));
            data.add(new ViewModel(R.drawable.number_02, R.drawable.background_4, "TWO", R.raw.audio_number_two, "#5D4037"));
            data.add(new ViewModel(R.drawable.number_03, R.drawable.background_4, "THREE", R.raw.audio_number_three, "#3E2723"));
            data.add(new ViewModel(R.drawable.number_04, R.drawable.background_4, "FOUR", R.raw.audio_number_four, "#FF6F00"));
            data.add(new ViewModel(R.drawable.number_05, R.drawable.background_4, "FIVE", R.raw.audio_number_five, "#FF5722"));
            data.add(new ViewModel(R.drawable.number_06, R.drawable.background_4, "SIX", R.raw.audio_number_six, "#3E2723"));
            data.add(new ViewModel(R.drawable.number_07, R.drawable.background_4, "SEVEN", R.raw.audio_number_seven, "#303F9F"));
            data.add(new ViewModel(R.drawable.number_08, R.drawable.background_4, "EIGHT", R.raw.audio_number_eight, "#FFA726"));
            data.add(new ViewModel(R.drawable.number_09, R.drawable.background_4, "NINE", R.raw.audio_number_nine, "#FF8F00"));
            data.add(new ViewModel(R.drawable.number_10, R.drawable.background_4, "TEN", R.raw.audio_number_ten, "#303F9F"));
        }
        return data;
    }

    public static ArrayList<ViewModel> getFromProfession() {
        ArrayList<ViewModel> data = new ArrayList<>();
        if (!PrintfGlobal.getCountryCode().equalsIgnoreCase("IN")) {
            data.add(new ViewModel(R.drawable.profession_doctor, R.drawable.background_7, "DOCTOR", R.raw.audio_profession_doctor_us, "", "", -1, "#FF6F00"));
            data.add(new ViewModel(R.drawable.profession_actors, R.drawable.background_7, "ACTOR", R.raw.audio_profession_actors_us, "", "", -1, "#0050ef"));
            data.add(new ViewModel(R.drawable.profession_busdrives, R.drawable.background_5, "BUS DRIVER", R.raw.audio_profession_bus_drives_us, "", "", -1, "#76608a"));
            data.add(new ViewModel(R.drawable.profession_engineers, R.drawable.background_5, "ENGINEER", R.raw.audio_profession_engineers_us, "", "", -1, "#6a00ff"));
            data.add(new ViewModel(R.drawable.profession_farmers, R.drawable.background_5, "FARMER", R.raw.audio_profession_farmers_us, "", "", -1, "#FF6F00"));
            data.add(new ViewModel(R.drawable.profession_fireman, R.drawable.background_5, "FIRE MAN", R.raw.audio_profession_fireman_us, "", "", -1, "#d50000"));
            data.add(new ViewModel(R.drawable.profession_tailor, R.drawable.background_5, "TAILOR", R.raw.audio_profession_tailor_us, "", "", -1, "#a4c400"));
            data.add(new ViewModel(R.drawable.profession_massage_therapist, R.drawable.background_7, "MASSAGE THERAPIST", R.raw.audio_profession_massage_therapist_us, "", "", -1, "#f0a30a"));
            data.add(new ViewModel(R.drawable.profession_piloat, R.drawable.background_5, "PILOT", R.raw.audio_profession_pilot_us, "", "", -1, "#6a00ff"));
            data.add(new ViewModel(R.drawable.profession_plumber, R.drawable.background_5, "PLUMBER", R.raw.audio_profession_plumber_us, "", "", -1, "#0050ef"));
            data.add(new ViewModel(R.drawable.profession_police, R.drawable.background_5, "POLICE", R.raw.audio_profession_police_us, "", "", -1, "#4CAF50"));
            data.add(new ViewModel(R.drawable.profession_professor, R.drawable.background_5, "PROFESSOR", R.raw.audio_profession_professor_us, "", "", -1, "#a20025"));
            data.add(new ViewModel(R.drawable.profession_reporter, R.drawable.background_5, "REPORTER", R.raw.audio_profession_repoter_us, "", "", -1, "#d80073"));
            data.add(new ViewModel(R.drawable.profession_teachers, R.drawable.background_5, "TEACHER", R.raw.audio_profession_teachers_us, "", "", -1, "#f472d0"));
            data.add(new ViewModel(R.drawable.profession_truckdrivers, R.drawable.background_5, "TRUCK DRIVER", R.raw.audio_profession_truck_drivers_us, "", "", -1, "#825a2c"));
        } else {
            data.add(new ViewModel(R.drawable.profession_doctor, R.drawable.background_7, "DOCTOR", R.raw.audio_profession_doctor, "", "", -1, "#FF6F00"));
            data.add(new ViewModel(R.drawable.profession_actors, R.drawable.background_7, "ACTOR", R.raw.audio_profession_actors, "", "", -1, "#0050ef"));
            data.add(new ViewModel(R.drawable.profession_busdrives, R.drawable.background_5, "BUS DRIVER", R.raw.audio_profession_bus_drives, "", "", -1, "#76608a"));
            data.add(new ViewModel(R.drawable.profession_engineers, R.drawable.background_5, "ENGINEER", R.raw.audio_profession_engineers, "", "", -1, "#6a00ff"));
            data.add(new ViewModel(R.drawable.profession_farmers, R.drawable.background_5, "FARMER", R.raw.audio_profession_farmers, "", "", -1, "#FF6F00"));
            data.add(new ViewModel(R.drawable.profession_fireman, R.drawable.background_5, "FIRE MAN", R.raw.audio_profession_fireman, "", "", -1, "#d50000"));
            data.add(new ViewModel(R.drawable.profession_tailor, R.drawable.background_5, "TAILOR", R.raw.audio_profession_tailor, "", "", -1, "#a4c400"));
            data.add(new ViewModel(R.drawable.profession_massage_therapist, R.drawable.background_7, "MASSAGE THERAPIST", R.raw.audio_profession_massage_therapist, "", "", -1, "#f0a30a"));
            data.add(new ViewModel(R.drawable.profession_piloat, R.drawable.background_5, "PILOT", R.raw.audio_profession_pilot, "", "", -1, "#6a00ff"));
            data.add(new ViewModel(R.drawable.profession_plumber, R.drawable.background_5, "PLUMBER", R.raw.audio_profession_plumber, "", "", -1, "#0050ef"));
            data.add(new ViewModel(R.drawable.profession_police, R.drawable.background_5, "POLICE", R.raw.audio_profession_police, "", "", -1, "#4CAF50"));
            data.add(new ViewModel(R.drawable.profession_professor, R.drawable.background_5, "PROFESSOR", R.raw.audio_profession_professor, "", "", -1, "#a20025"));
            data.add(new ViewModel(R.drawable.profession_reporter, R.drawable.background_5, "REPORTER", R.raw.audio_profession_repoter, "", "", -1, "#d80073"));
            data.add(new ViewModel(R.drawable.profession_teachers, R.drawable.background_5, "TEACHER", R.raw.audio_profession_teachers, "", "", -1, "#f472d0"));
            data.add(new ViewModel(R.drawable.profession_truckdrivers, R.drawable.background_5, "TRUCK DRIVER", R.raw.audio_profession_truck_drivers, "", "", -1, "#825a2c"));
        }
        return data;
    }

    public static ArrayList<ViewModel> getFromShape() {
        ArrayList<ViewModel> data = new ArrayList<>();
        if (!PrintfGlobal.getCountryCode().equalsIgnoreCase("IN")) {
            data.add(new ViewModel(R.drawable.shape_circle, R.drawable.background_4, "CIRCLE", R.raw.audio_shape_circle_us, "#FAFAFA"));
            data.add(new ViewModel(R.drawable.shape_polygon, R.drawable.background_4, "POLYGON", R.raw.audio_shape_polygon_us, "#5D4037"));
            data.add(new ViewModel(R.drawable.shape_rectangle, R.drawable.background_4, "RECTANGLE", R.raw.audio_shape_rectangle_us, "#3E2723"));
            data.add(new ViewModel(R.drawable.shape_square, R.drawable.background_4, "SQUARE", R.raw.audio_shape_square_us, "#303F9F"));
            data.add(new ViewModel(R.drawable.shape_triangle, R.drawable.background_4, "TRIANGLE", R.raw.audio_shape_triangle_us, "#FFA726"));
        } else {
            data.add(new ViewModel(R.drawable.shape_circle, R.drawable.background_4, "CIRCLE", R.raw.audio_shape_circle, "#FAFAFA"));
            data.add(new ViewModel(R.drawable.shape_polygon, R.drawable.background_4, "POLYGON", R.raw.audio_shape_polygon, "#5D4037"));
            data.add(new ViewModel(R.drawable.shape_rectangle, R.drawable.background_4, "RECTANGLE", R.raw.audio_shape_rectangle, "#3E2723"));
            data.add(new ViewModel(R.drawable.shape_square, R.drawable.background_4, "SQUARE", R.raw.audio_shape_square, "#303F9F"));
            data.add(new ViewModel(R.drawable.shape_triangle, R.drawable.background_4, "TRIANGLE", R.raw.audio_shape_triangle, "#FFA726"));
        }
        return data;
    }

    public static ArrayList<ViewModel> getFromSports() {
        ArrayList<ViewModel> data = new ArrayList<>();
        if (!PrintfGlobal.getCountryCode().equalsIgnoreCase("IN")) {
            data.add(new ViewModel(R.drawable.sport_cricket, R.drawable.background_8, "CRICKET", R.raw.audio_sport_cricket_us, "#dd4b39"));
            data.add(new ViewModel(R.drawable.sport_football, R.drawable.background_8, "FOOTBALL", R.raw.audio_sport_football_us, "#af0606"));
            data.add(new ViewModel(R.drawable.sport_polo, R.drawable.background_8, "POLO", R.raw.audio_sport_polo_us, "#e4405f"));
            data.add(new ViewModel(R.drawable.sport_archery, R.drawable.background_8, "ARCHERY", R.raw.audio_sport_archery_us, "#ff0084"));
            data.add(new ViewModel(R.drawable.sport_baseball, R.drawable.background_8, "BASEBALL", R.raw.audio_sport_baseball_us, "#FFFC00"));
            data.add(new ViewModel(R.drawable.sport_boxer, R.drawable.background_8, "BOXING", R.raw.audio_sport_boxing_us, "#131418"));
            data.add(new ViewModel(R.drawable.sport_cycling, R.drawable.background_8, "CYCLING", R.raw.audio_sport_cycling_us, "#DD2C00"));
            data.add(new ViewModel(R.drawable.sport_golf, R.drawable.background_8, "GOLF", R.raw.audio_sport_golf_us, "#0077b5"));
            data.add(new ViewModel(R.drawable.sport_horse_raching, R.drawable.background_8, "HORSE RACING", R.raw.audio_sport_horse_racing_us, "#4c75a3"));
            data.add(new ViewModel(R.drawable.sport_surfing, R.drawable.background_8, "SURFING", R.raw.audio_sport_surfing_us, "#410093"));
            data.add(new ViewModel(R.drawable.sport_swimming, R.drawable.background_4, "SWIMMING", R.raw.audio_sport_swimming_us, "#ff5700"));
            data.add(new ViewModel(R.drawable.sport_tennis, R.drawable.background_8, "TENNIS", R.raw.audio_sport_tennis_us, "#f57d00"));
            data.add(new ViewModel(R.drawable.sport_yoga, R.drawable.background_8, "YOGA", R.raw.audio_sport_yoga_us, "#da552f"));
        } else {
            data.add(new ViewModel(R.drawable.sport_cricket, R.drawable.background_8, "CRICKET", R.raw.audio_sport_cricket, "#dd4b39"));
            data.add(new ViewModel(R.drawable.sport_football, R.drawable.background_8, "FOOTBALL", R.raw.audio_sport_football, "#af0606"));
            data.add(new ViewModel(R.drawable.sport_polo, R.drawable.background_8, "POLO", R.raw.audio_sport_polo, "#e4405f"));
            data.add(new ViewModel(R.drawable.sport_archery, R.drawable.background_8, "ARCHERY", R.raw.audio_sport_archery, "#ff0084"));
            data.add(new ViewModel(R.drawable.sport_baseball, R.drawable.background_8, "BASEBALL", R.raw.audio_sport_baseball, "#FFFC00"));
            data.add(new ViewModel(R.drawable.sport_boxer, R.drawable.background_8, "BOXING", R.raw.audio_sport_boxing, "#131418"));
            data.add(new ViewModel(R.drawable.sport_cycling, R.drawable.background_8, "CYCLING", R.raw.audio_sport_cycling, "#DD2C00"));
            data.add(new ViewModel(R.drawable.sport_golf, R.drawable.background_8, "GOLF", R.raw.audio_sport_golf, "#0077b5"));
            data.add(new ViewModel(R.drawable.sport_horse_raching, R.drawable.background_8, "HORSE RACING", R.raw.audio_sport_horse_racing, "#4c75a3"));
            data.add(new ViewModel(R.drawable.sport_surfing, R.drawable.background_8, "SURFING", R.raw.audio_sport_surfing, "#410093"));
            data.add(new ViewModel(R.drawable.sport_swimming, R.drawable.background_4, "SWIMMING", R.raw.audio_sport_swimming, "#ff5700"));
            data.add(new ViewModel(R.drawable.sport_tennis, R.drawable.background_8, "TENNIS", R.raw.audio_sport_tennis, "#f57d00"));
            data.add(new ViewModel(R.drawable.sport_yoga, R.drawable.background_8, "YOGA", R.raw.audio_sport_yoga, "#da552f"));
        }
        return data;
    }

    public static ArrayList<ViewModel> getFromTransport() {
        ArrayList<ViewModel> data = new ArrayList<>();
        if (!PrintfGlobal.getCountryCode().equalsIgnoreCase("IN")) {
            data.add(new ViewModel(R.drawable.transport_bicycle, R.drawable.background_5, "BICYCLE", R.raw.audio_transport_bicycle_us, "#FFA726"));
            data.add(new ViewModel(R.drawable.transport_airplane, R.drawable.background_5, "AIRPLANE", R.raw.audio_transport_airoplane_us, "#FAFAFA"));
            data.add(new ViewModel(R.drawable.transport_scooter, R.drawable.background_5, "SCOOTER", R.raw.audio_transport_scooter_us, "#5D4037"));
            data.add(new ViewModel(R.drawable.transport_bus, R.drawable.background_5, "BUS", R.raw.audio_transport_bus_us, "#3E2723"));
            data.add(new ViewModel(R.drawable.transport_car, R.drawable.background_5, "CAR", R.raw.audio_transport_car_us, "#303F9F"));
            data.add(new ViewModel(R.drawable.transport_boat, R.drawable.background_3, "BOAT", R.raw.audio_transport_boat_us, "#FFAB00"));
            data.add(new ViewModel(R.drawable.transport_dump_truck, R.drawable.background_5, "TRUCK", R.raw.audio_transport_dump_truck_us, "#7CB342"));
            data.add(new ViewModel(R.drawable.transport_train, R.drawable.background_5, "TRAIN", R.raw.audio_transport_train_us, "#F4511E"));
            data.add(new ViewModel(R.drawable.transport_tractor, R.drawable.background_5, "TRACTOR", R.raw.audio_transport_tractor_us, "#F4511E"));
            data.add(new ViewModel(R.drawable.transport_helicopter, R.drawable.background_5, "HELICOPTER", R.raw.audio_transport_helicopter_us, "#ff1744"));
            data.add(new ViewModel(R.drawable.transport_balloon, R.drawable.background_5, "BALLOON", R.raw.audio_transport_balloon_us, "#AB47BC"));
            data.add(new ViewModel(R.drawable.transport_cement_mixer, R.drawable.background_5, "CEMENT MIXER", R.raw.audio_transport_cement_mixer_us, "#7CB342"));
            data.add(new ViewModel(R.drawable.transport_crane, R.drawable.background_5, "CRANE", R.raw.audio_transport_crane_us, "#F06292"));
            data.add(new ViewModel(R.drawable.transport_ferry, R.drawable.background_3, "FERRY", R.raw.audio_transport_ferry_us, "#311B92"));
            data.add(new ViewModel(R.drawable.transport_lorry, R.drawable.background_5, "LORRY", R.raw.audio_transport_lorry_us, "#CDDC39"));
            data.add(new ViewModel(R.drawable.transport_mimibus, R.drawable.background_5, "MINI BUS", R.raw.audio_transport_mimibus_us, "#6D4C41"));
            data.add(new ViewModel(R.drawable.transport_motorcycle, R.drawable.background_5, "MOTOR CYCLE", R.raw.audio_transport_motorcycle_us, "#FF6F00"));
            data.add(new ViewModel(R.drawable.transport_rocket, R.drawable.background_5, "ROCKET", R.raw.audio_transport_rocket_us, "#D81B60"));
            data.add(new ViewModel(R.drawable.transport_ship, R.drawable.background_3, "SHIP", R.raw.audio_transport_ship_us, "#FF6F00"));
            data.add(new ViewModel(R.drawable.transport_van, R.drawable.background_5, "VAN", R.raw.audio_transport_van_us, "#3F51B5"));
        } else {
            data.add(new ViewModel(R.drawable.transport_bicycle, R.drawable.background_5, "BICYCLE", R.raw.audio_transport_bicycle, "#FFA726"));
            data.add(new ViewModel(R.drawable.transport_airplane, R.drawable.background_5, "AIRPLANE", R.raw.audio_transport_airoplane, "#FAFAFA"));
            data.add(new ViewModel(R.drawable.transport_scooter, R.drawable.background_5, "SCOOTER", R.raw.audio_transport_scooter, "#5D4037"));
            data.add(new ViewModel(R.drawable.transport_bus, R.drawable.background_5, "BUS", R.raw.audio_transport_bus, "#3E2723"));
            data.add(new ViewModel(R.drawable.transport_car, R.drawable.background_5, "CAR", R.raw.audio_transport_car, "#303F9F"));
            data.add(new ViewModel(R.drawable.transport_boat, R.drawable.background_3, "BOAT", R.raw.audio_transport_boat, "#FFAB00"));
            data.add(new ViewModel(R.drawable.transport_dump_truck, R.drawable.background_5, "TRUCK", R.raw.audio_transport_dump_truck, "#7CB342"));
            data.add(new ViewModel(R.drawable.transport_train, R.drawable.background_5, "TRAIN", R.raw.audio_transport_train, "#F4511E"));
            data.add(new ViewModel(R.drawable.transport_tractor, R.drawable.background_5, "TRACTOR", R.raw.audio_transport_tractor, "#F4511E"));
            data.add(new ViewModel(R.drawable.transport_helicopter, R.drawable.background_5, "HELICOPTER", R.raw.audio_transport_helicopter, "#ff1744"));
            data.add(new ViewModel(R.drawable.transport_balloon, R.drawable.background_5, "BALLOON", R.raw.audio_transport_balloon, "#AB47BC"));
            data.add(new ViewModel(R.drawable.transport_cement_mixer, R.drawable.background_5, "CEMENT MIXER", R.raw.audio_transport_cement_mixer, "#7CB342"));
            data.add(new ViewModel(R.drawable.transport_crane, R.drawable.background_5, "CRANE", R.raw.audio_transport_crane, "#F06292"));
            data.add(new ViewModel(R.drawable.transport_ferry, R.drawable.background_3, "FERRY", R.raw.audio_transport_ferry, "#311B92"));
            data.add(new ViewModel(R.drawable.transport_lorry, R.drawable.background_5, "LORRY", R.raw.audio_transport_lorry, "#CDDC39"));
            data.add(new ViewModel(R.drawable.transport_mimibus, R.drawable.background_5, "MINI BUS", R.raw.audio_transport_mimibus, "#6D4C41"));
            data.add(new ViewModel(R.drawable.transport_motorcycle, R.drawable.background_5, "MOTOR CYCLE", R.raw.audio_transport_motorcycle, "#FF6F00"));
            data.add(new ViewModel(R.drawable.transport_rocket, R.drawable.background_5, "ROCKET", R.raw.audio_transport_rocket, "#D81B60"));
            data.add(new ViewModel(R.drawable.transport_ship, R.drawable.background_3, "SHIP", R.raw.audio_transport_ship, "#FF6F00"));
            data.add(new ViewModel(R.drawable.transport_van, R.drawable.background_5, "VAN", R.raw.audio_transport_van, "#3F51B5"));
        }
        return data;
    }

    public static ArrayList<ViewModel> getFromFruitTree() {
        ArrayList<ViewModel> data = new ArrayList<>();
        if (!PrintfGlobal.getCountryCode().equalsIgnoreCase("IN")) {
            data.add(new ViewModel(R.drawable.tree_almond, R.drawable.background_5, "ALMOND", R.raw.audio_tree_almond_us, "#9C27B0"));
            data.add(new ViewModel(R.drawable.tree_avocado, R.drawable.background_5, "AVOCADO", R.raw.audio_tree_avocado_tree_us, "#e57373"));
            data.add(new ViewModel(R.drawable.tree_balckberry, R.drawable.background_5, "BLACKBERRY", R.raw.audio_tree_balck_berry_us, "#D500F9"));
            data.add(new ViewModel(R.drawable.tree_banana, R.drawable.background_5, "BANANA", R.raw.audio_tree_banana_us, "#FFF176"));
            data.add(new ViewModel(R.drawable.tree_chiku, R.drawable.background_5, "CHIKU", R.raw.audio_tree_chiku_tree_us, "#66BB6A"));
            data.add(new ViewModel(R.drawable.tree_coconut, R.drawable.background_5, "COCONUT", R.raw.audio_tree_coconut_us, "#424242"));
            data.add(new ViewModel(R.drawable.tree_guava, R.drawable.background_5, "GUAVA", R.raw.audio_tree_guava_us, "#3F51B5"));
            data.add(new ViewModel(R.drawable.tree_lemon, R.drawable.background_5, "LEMON", R.raw.audio_tree_lemon_tree_us, "#673AB7"));
            data.add(new ViewModel(R.drawable.tree_mango, R.drawable.background_5, "MANGO", R.raw.audio_tree_mango_tree_us, "#DD2C00"));
            data.add(new ViewModel(R.drawable.tree_orange, R.drawable.background_5, "ORANGE", R.raw.audio_tree_orange_tree_us, "#80DEEA"));
            data.add(new ViewModel(R.drawable.tree_papaya, R.drawable.background_5, "PAPAYA", R.raw.audio_tree_papaya_us, "#81D4FA"));
            data.add(new ViewModel(R.drawable.tree_pinaple, R.drawable.background_5, "PINEAPPLE", R.raw.audio_tree_pineapple_tree_us, "#BCAAA4"));
            data.add(new ViewModel(R.drawable.tree_star_fruit, R.drawable.background_5, "STAR FRUIT", R.raw.audio_tree_star_fruit_us, "#e53935"));
            data.add(new ViewModel(R.drawable.tree_strawberry, R.drawable.background_5, "STRAWBERRY", R.raw.audio_tree_strawberry_us, "#FF6D00"));
            data.add(new ViewModel(R.drawable.tree_sugar_apple, R.drawable.background_5, "SUGAR APPLE", R.raw.audio_tree_sugar_apple_us, "#FFA000"));
        } else {
            data.add(new ViewModel(R.drawable.tree_almond, R.drawable.background_5, "ALMOND", R.raw.audio_tree_almond, "#9C27B0"));
            data.add(new ViewModel(R.drawable.tree_avocado, R.drawable.background_5, "AVOCADO", R.raw.audio_tree_avocado_tree, "#e57373"));
            data.add(new ViewModel(R.drawable.tree_balckberry, R.drawable.background_5, "BLACKBERRY", R.raw.audio_tree_balck_berry, "#D500F9"));
            data.add(new ViewModel(R.drawable.tree_banana, R.drawable.background_5, "BANANA", R.raw.audio_tree_banana, "#FFF176"));
            data.add(new ViewModel(R.drawable.tree_chiku, R.drawable.background_5, "CHIKU", R.raw.audio_tree_chiku_tree, "#66BB6A"));
            data.add(new ViewModel(R.drawable.tree_coconut, R.drawable.background_5, "COCONUT", R.raw.audio_tree_coconut, "#424242"));
            data.add(new ViewModel(R.drawable.tree_guava, R.drawable.background_5, "GUAVA", R.raw.audio_tree_guava, "#3F51B5"));
            data.add(new ViewModel(R.drawable.tree_lemon, R.drawable.background_5, "LEMON", R.raw.audio_tree_lemon_tree, "#673AB7"));
            data.add(new ViewModel(R.drawable.tree_mango, R.drawable.background_5, "MANGO", R.raw.audio_tree_mango_tree, "#DD2C00"));
            data.add(new ViewModel(R.drawable.tree_orange, R.drawable.background_5, "ORANGE", R.raw.audio_tree_orange_tree, "#80DEEA"));
            data.add(new ViewModel(R.drawable.tree_papaya, R.drawable.background_5, "PAPAYA", R.raw.audio_tree_papaya, "#81D4FA"));
            data.add(new ViewModel(R.drawable.tree_pinaple, R.drawable.background_5, "PINEAPPLE", R.raw.audio_tree_pineapple_tree, "#BCAAA4"));
            data.add(new ViewModel(R.drawable.tree_star_fruit, R.drawable.background_5, "STAR FRUIT", R.raw.audio_tree_star_fruit, "#e53935"));
            data.add(new ViewModel(R.drawable.tree_strawberry, R.drawable.background_5, "STRAWBERRY", R.raw.audio_tree_strawberry, "#FF6D00"));
            data.add(new ViewModel(R.drawable.tree_sugar_apple, R.drawable.background_5, "SUGAR APPLE", R.raw.audio_tree_sugar_apple, "#FFA000"));
        }
        return data;
    }

    public static ArrayList<ViewModel> getFromVegetable() {
        ArrayList<ViewModel> data = new ArrayList<>();
        if (!PrintfGlobal.getCountryCode().equalsIgnoreCase("IN")) {
            data.add(new ViewModel(R.drawable.vagitable_aubergines, R.drawable.background_1, "AUBERGINES", R.raw.audio_veg_aubergines_us, "#FF6D00"));
            data.add(new ViewModel(R.drawable.vagitable_broccoli, R.drawable.background_1, "BROCCOLI", R.raw.audio_veg_broccoli_us, "#C51162"));
            data.add(new ViewModel(R.drawable.vagitable_cabbage, R.drawable.background_1, "CABBAGE", R.raw.audio_veg_cabbage_us, "#f44336"));
            data.add(new ViewModel(R.drawable.vagitable_carrot, R.drawable.background_1, "CARROT", R.raw.audio_veg_carrot_us, "#E64A19"));
            data.add(new ViewModel(R.drawable.vagitable_cauliflower, R.drawable.background_1, "CAULIFLOWER", R.raw.audio_veg_cauliflower_us, "#795548"));
            data.add(new ViewModel(R.drawable.vagitable_celery, R.drawable.background_1, "CELERY", R.raw.audio_veg_celery_us, "#6D4C41"));
            data.add(new ViewModel(R.drawable.vagitable_corn, R.drawable.background_1, "CORN", R.raw.audio_veg_corn_us, "#FFAB91"));
            data.add(new ViewModel(R.drawable.vagitable_green_bean, R.drawable.background_1, "GREEN BEAN", R.raw.audio_veg_green_bean_us, "#FFE0B2"));
            data.add(new ViewModel(R.drawable.vagitable_green_pepper, R.drawable.background_1, "GREEN PEPPER", R.raw.audio_veg_green_pepper_us, "#DCEDC8"));
            data.add(new ViewModel(R.drawable.vagitable_lettuce, R.drawable.background_1, "LETTUCE", R.raw.audio_veg_lettuce_us, "#80CBC4"));
            data.add(new ViewModel(R.drawable.vagitable_patatoes, R.drawable.background_1, "POTATOES", R.raw.audio_veg_patatoes_us, "#5D4037"));
            data.add(new ViewModel(R.drawable.vagitable_pumpkin, R.drawable.background_1, "PUMPKIN", R.raw.audio_veg_pumpkin_us, "#9C27B0"));
            data.add(new ViewModel(R.drawable.vagitable_radish, R.drawable.background_1, "BITROOT", R.raw.audio_veg_bitroot_us, "#3949AB"));
            data.add(new ViewModel(R.drawable.vagitable_red_pepper, R.drawable.background_1, "RED PEPPER", R.raw.audio_veg_red_pepper_us, "#00796B"));
            data.add(new ViewModel(R.drawable.vagitable_sweet_patatoes, R.drawable.background_1, "SWEET POTATOES", R.raw.audio_veg_sweet_patatoes_us, "#6D4C41"));
            data.add(new ViewModel(R.drawable.vagitable_tomatoes, R.drawable.background_1, "TOMATO", R.raw.audio_veg_tomatoes_us, "#d50000"));
        } else {
            data.add(new ViewModel(R.drawable.vagitable_aubergines, R.drawable.background_1, "AUBERGINES", R.raw.audio_veg_aubergines, "#FF6D00"));
            data.add(new ViewModel(R.drawable.vagitable_broccoli, R.drawable.background_1, "BROCCOLI", R.raw.audio_veg_broccoli, "#C51162"));
            data.add(new ViewModel(R.drawable.vagitable_cabbage, R.drawable.background_1, "CABBAGE", R.raw.audio_veg_cabbage, "#f44336"));
            data.add(new ViewModel(R.drawable.vagitable_carrot, R.drawable.background_1, "CARROT", R.raw.audio_veg_carrot, "#E64A19"));
            data.add(new ViewModel(R.drawable.vagitable_cauliflower, R.drawable.background_1, "CAULIFLOWER", R.raw.audio_veg_cauliflower, "#795548"));
            data.add(new ViewModel(R.drawable.vagitable_celery, R.drawable.background_1, "CELERY", R.raw.audio_veg_celery, "#6D4C41"));
            data.add(new ViewModel(R.drawable.vagitable_corn, R.drawable.background_1, "CORN", R.raw.audio_veg_corn, "#FFAB91"));
            data.add(new ViewModel(R.drawable.vagitable_green_bean, R.drawable.background_1, "GREEN BEAN", R.raw.audio_veg_green_bean, "#FFE0B2"));
            data.add(new ViewModel(R.drawable.vagitable_green_pepper, R.drawable.background_1, "GREEN PEPPER", R.raw.audio_veg_green_pepper, "#DCEDC8"));
            data.add(new ViewModel(R.drawable.vagitable_lettuce, R.drawable.background_1, "LETTUCE", R.raw.audio_veg_lettuce, "#80CBC4"));
            data.add(new ViewModel(R.drawable.vagitable_patatoes, R.drawable.background_1, "POTATOES", R.raw.audio_veg_patatoes, "#5D4037"));
            data.add(new ViewModel(R.drawable.vagitable_pumpkin, R.drawable.background_1, "PUMPKIN", R.raw.audio_veg_pumpkin, "#9C27B0"));
            data.add(new ViewModel(R.drawable.vagitable_radish, R.drawable.background_1, "BITROOT", R.raw.audio_veg_bitroot, "#3949AB"));
            data.add(new ViewModel(R.drawable.vagitable_red_pepper, R.drawable.background_1, "RED PEPPER", R.raw.audio_veg_red_pepper, "#00796B"));
            data.add(new ViewModel(R.drawable.vagitable_sweet_patatoes, R.drawable.background_1, "SWEET POTATOES", R.raw.audio_veg_sweet_patatoes, "#6D4C41"));
            data.add(new ViewModel(R.drawable.vagitable_tomatoes, R.drawable.background_1, "TOMATO", R.raw.audio_veg_tomatoes, "#d50000"));
        }
        return data;
    }

    /********************* Read End *********************/

    /********************* Write Start *********************/

    public static ArrayList<WriteBeen> getAlphabet_() {
        ArrayList<WriteBeen> list = new ArrayList<>();
        list.add(new WriteBeen("A", R.drawable.alphabet_apple_write));
        list.add(new WriteBeen("B", R.drawable.alphabet_ball_write));
        list.add(new WriteBeen("C", R.drawable.alphabet_cat_write));
        list.add(new WriteBeen("D", R.drawable.alphabet_dog_write));
        list.add(new WriteBeen("E", R.drawable.alphabet_elephant_write));
        list.add(new WriteBeen("F", R.drawable.alphabet_fish_write));
        list.add(new WriteBeen("G", R.drawable.alphabet_got_write));
        list.add(new WriteBeen("H", R.drawable.alphabet_hourse_write));
        list.add(new WriteBeen("I", R.drawable.alphabet_icecreame_write));
        list.add(new WriteBeen("J", R.drawable.alphabet_jug_write));
        list.add(new WriteBeen("K", R.drawable.alphabet_kite_write));
        list.add(new WriteBeen("L", R.drawable.alphabet_line_write));
        list.add(new WriteBeen("M", R.drawable.alphabet_monkey_write));
        list.add(new WriteBeen("N", R.drawable.alphabet_hen_write));
        list.add(new WriteBeen("O", R.drawable.alphabet_owl_write));
        list.add(new WriteBeen("P", R.drawable.alphabet_parret_write));
        list.add(new WriteBeen("Q", R.drawable.alphabet_queen_write));
        list.add(new WriteBeen("R", R.drawable.alphabet_rabbit_write));
        list.add(new WriteBeen("S", R.drawable.alphabet_snack_write));
        list.add(new WriteBeen("T", R.drawable.alphabet_tiger_write));
        list.add(new WriteBeen("U", R.drawable.alphabet_umbrella_write));
        list.add(new WriteBeen("V", R.drawable.alphabet_van_write));
        list.add(new WriteBeen("W", R.drawable.alphabet_watch_write));
        list.add(new WriteBeen("X", R.drawable.alphabet_x_write));
        list.add(new WriteBeen("Y", R.drawable.alphabet_yark_write));
        list.add(new WriteBeen("Z", R.drawable.alphabet_zebra_write));
        return list;
    }

    public static ArrayList<WriteBeen> getFromNumbers_() {
        ArrayList<WriteBeen> data = new ArrayList<>();
        data.add(new WriteBeen("ONE", R.drawable.number_01_write));
        data.add(new WriteBeen("TWO", R.drawable.number_02_write));
        data.add(new WriteBeen("THREE", R.drawable.number_03_write));
        data.add(new WriteBeen("FOUR", R.drawable.number_04_write));
        data.add(new WriteBeen("FIVE", R.drawable.number_05_write));
        data.add(new WriteBeen("SIX", R.drawable.number_06_write));
        data.add(new WriteBeen("SEVEN", R.drawable.number_07_write));
        data.add(new WriteBeen("EIGHT", R.drawable.number_08_write));
        data.add(new WriteBeen("NINE", R.drawable.number_09_write));
        data.add(new WriteBeen("TEN", R.drawable.number_10_write));
        return data;
    }

    public static ArrayList<WriteBeen> getFromShape_() {
        ArrayList<WriteBeen> data = new ArrayList<>();
        data.add(new WriteBeen(R.drawable.shape_circle_write, "CIRCLE"));
        data.add(new WriteBeen(R.drawable.shape_polygon_write, "OVAL"));
        data.add(new WriteBeen(R.drawable.shape_rectangle_write, "RECTANGLE"));
        data.add(new WriteBeen(R.drawable.shape_square_write, "SQUARE"));
        data.add(new WriteBeen(R.drawable.shape_triangle_write, "TRIANGLE"));
        return data;
    }

    public static ArrayList<WriteBeen> getFromMonths_() {
        ArrayList<WriteBeen> data = new ArrayList<>();
        data.add(new WriteBeen(R.drawable.month_january_write, "JANUARY"));
        data.add(new WriteBeen(R.drawable.month_february_write, "FEBRUARY"));
        data.add(new WriteBeen(R.drawable.month_march_write, "MARCH"));
        data.add(new WriteBeen(R.drawable.month_april_write, "APRIL"));
        data.add(new WriteBeen(R.drawable.month_may_write, "MAY"));
        data.add(new WriteBeen(R.drawable.month_june_write, "JUNE"));
        data.add(new WriteBeen(R.drawable.month_july_write, "July"));
        data.add(new WriteBeen(R.drawable.month_august_write, "AUGUST"));
        data.add(new WriteBeen(R.drawable.month_september_write, "SEPTEMBER"));
        data.add(new WriteBeen(R.drawable.month_october_write, "OCTOBER"));
        data.add(new WriteBeen(R.drawable.month_november_write, "NOVEMBER"));
        data.add(new WriteBeen(R.drawable.month_december_write, "DECEMBER"));
        return data;
    }

    public static ArrayList<WriteBeen> getFromTransport_() {
        ArrayList<WriteBeen> data = new ArrayList<>();
        data.add(new WriteBeen(R.drawable.transport_bicycle_write, "BICYCLE"));
        data.add(new WriteBeen(R.drawable.transport_airplane_write, "AIRPLANE"));
        data.add(new WriteBeen(R.drawable.transport_scooter_write, "SCOOTER"));
        data.add(new WriteBeen(R.drawable.transport_bus_write, "BUS"));
        data.add(new WriteBeen(R.drawable.transport_car_write, "CAR"));
        data.add(new WriteBeen(R.drawable.transport_boat_write, "BOAT"));
        data.add(new WriteBeen(R.drawable.transport_dump_truck_write, "TRUCK"));
        data.add(new WriteBeen(R.drawable.transport_train_write, "TRAIN"));
        data.add(new WriteBeen(R.drawable.transport_tractor_write, "TRACTOR"));
        data.add(new WriteBeen(R.drawable.transport_helicopter_write, "HELICOPTER"));
        data.add(new WriteBeen(R.drawable.transport_balloon_write, "BALLOON"));
        data.add(new WriteBeen(R.drawable.transport_cement_mixer_write, "CEMENT MIXER"));
        data.add(new WriteBeen(R.drawable.transport_crane_write, "CRANE"));
        data.add(new WriteBeen(R.drawable.transport_ferry_write, "FERRY"));
        data.add(new WriteBeen(R.drawable.transport_lorry_write, "LORRY"));
        data.add(new WriteBeen(R.drawable.transport_mimibus_write, "MINI BUS"));
        data.add(new WriteBeen(R.drawable.transport_motorcycle_write, "MOTOR CYCLE"));
        data.add(new WriteBeen(R.drawable.transport_rocket_write, "ROCKET"));
        data.add(new WriteBeen(R.drawable.transport_ship_write, "SHIP"));
        data.add(new WriteBeen(R.drawable.transport_van_write, "VAN"));
        return data;
    }

    public static ArrayList<WriteBeen> getFromAnimals_() {
        ArrayList<WriteBeen> data = new ArrayList<>();
        data.add(new WriteBeen(R.drawable.animal_dog_write, "DOG"));
        data.add(new WriteBeen(R.drawable.animal_elephant_write, "ELEPHANT"));
        data.add(new WriteBeen(R.drawable.animal_horse_write, "HORSE"));
        data.add(new WriteBeen(R.drawable.animal_cheetah_write, "CHEETAH"));
        data.add(new WriteBeen(R.drawable.animal_lion_write, "LION"));
        data.add(new WriteBeen(R.drawable.animal_tiger_write, "TIGER"));
        data.add(new WriteBeen(R.drawable.animal_pig_write, "PIG"));
        data.add(new WriteBeen(R.drawable.animal_zebra_write, "ZEBRA"));
        data.add(new WriteBeen(R.drawable.animal_dear_write, "DEAR"));
        data.add(new WriteBeen(R.drawable.animal_donkey_write, "DONKEY"));
        data.add(new WriteBeen(R.drawable.animal_sheep_write, "SHEEP"));
        data.add(new WriteBeen(R.drawable.animal_cat_write, "CAT"));
        data.add(new WriteBeen(R.drawable.animal_giraffe_write, "GIRAFFE"));
        data.add(new WriteBeen(R.drawable.animal_hippopotamus_write, "HIPPOPOTAMUS"));
        data.add(new WriteBeen(R.drawable.animal_cawfill_write, "COW"));
        data.add(new WriteBeen(R.drawable.animal_bear_write, "BEAR"));
        data.add(new WriteBeen(R.drawable.animal_goat_write, "GOAT"));
        data.add(new WriteBeen(R.drawable.animal_monkey_write, "MONKEY"));
        data.add(new WriteBeen(R.drawable.animal_bluewhale_write, "BLUE WHALE"));
        data.add(new WriteBeen(R.drawable.animal_chimpanzee_write, "CHIMPANZEE"));
        data.add(new WriteBeen(R.drawable.animal_crocodile_write, "CROCODILE"));
        data.add(new WriteBeen(R.drawable.animal_dolphin_write, "DOLPHIN"));
        data.add(new WriteBeen(R.drawable.animal_fox_write, "FOX"));
        data.add(new WriteBeen(R.drawable.animal_jaguar_write, "JAGUAR"));
        data.add(new WriteBeen(R.drawable.animal_kangaroo_write, "KANGAROO"));
        data.add(new WriteBeen(R.drawable.animal_killer_whale_write, "KILLER WHALE"));
        data.add(new WriteBeen(R.drawable.animal_octopus_write, "OCTOPUS"));
        data.add(new WriteBeen(R.drawable.animal_otter_write, "OTTER"));
        data.add(new WriteBeen(R.drawable.animal_oyster_write, "OYSTER"));
        data.add(new WriteBeen(R.drawable.animal_rabbit_write, "RABBIT"));
        data.add(new WriteBeen(R.drawable.animal_raccoon_write, "RACCOON"));
        data.add(new WriteBeen(R.drawable.animal_sea_urchin_write, "SEA URCHIN"));
        data.add(new WriteBeen(R.drawable.animal_shark_write, "SHARK"));
        data.add(new WriteBeen(R.drawable.animal_shells_write, "SHELLS"));
        data.add(new WriteBeen(R.drawable.animal_snake_write, "SNACK"));
        return data;
    }

    public static ArrayList<WriteBeen> getFromFruits_() {
        ArrayList<WriteBeen> data = new ArrayList<>();
        data.add(new WriteBeen(R.drawable.fruit_apple_write, "APPLE"));
        data.add(new WriteBeen(R.drawable.fruit_banana_write, "BANANA"));
        data.add(new WriteBeen(R.drawable.fruit_avocado_write, "AVOCADO"));
        data.add(new WriteBeen(R.drawable.fruit_mango_write, "MANGO"));
        data.add(new WriteBeen(R.drawable.fruit_orange_write, "ORANGE"));
        data.add(new WriteBeen(R.drawable.fruit_strawberry_write, "STRAWBERRY"));
        data.add(new WriteBeen(R.drawable.fruit_watermelon_write, "WATERMELON"));
        data.add(new WriteBeen(R.drawable.fruit_balckberry_write, "BLACKBERRY"));
        data.add(new WriteBeen(R.drawable.fruit_coconut_write, "COCONUT"));
        data.add(new WriteBeen(R.drawable.fruit_guava_write, "GUAVA"));
        data.add(new WriteBeen(R.drawable.fruit_lemon_write, "LEMON"));
        data.add(new WriteBeen(R.drawable.fruit_papaya_write, "PAPAYA"));
        data.add(new WriteBeen(R.drawable.fruit_pinaple_write, "PINEAPPLE"));
        data.add(new WriteBeen(R.drawable.fruit_star_write, "STAR"));
        data.add(new WriteBeen(R.drawable.fruit_sugar_apple_write, "SUGAR APPLE"));
        return data;
    }

    public static ArrayList<WriteBeen> getFromProfession_() {
        ArrayList<WriteBeen> data = new ArrayList<>();
        data.add(new WriteBeen(R.drawable.profession_doctor_write, "DOCTOR"));
        data.add(new WriteBeen(R.drawable.profession_actors_write, "ACTOR"));
        data.add(new WriteBeen(R.drawable.profession_busdrives_write, "BUS DRIVER"));
        data.add(new WriteBeen(R.drawable.profession_engineers_write, "ENGINEER"));
        data.add(new WriteBeen(R.drawable.profession_farmers_write, "FARMER"));
        data.add(new WriteBeen(R.drawable.profession_fireman_write, "FIRE MAN"));
        data.add(new WriteBeen(R.drawable.profession_tailor_write, "TAILOR"));
        data.add(new WriteBeen(R.drawable.profession_massage_therapist_write, "MASSAGE THERAPIST"));
        data.add(new WriteBeen(R.drawable.profession_piloat_write, "PILOT"));
        data.add(new WriteBeen(R.drawable.profession_plumber_write, "PLUMBER"));
        data.add(new WriteBeen(R.drawable.profession_police_write, "POLICE"));
        data.add(new WriteBeen(R.drawable.profession_professor_write, "PROFESSOR"));
        data.add(new WriteBeen(R.drawable.profession_reporter_write, "REPORTER"));
        data.add(new WriteBeen(R.drawable.profession_teachers_write, "TEACHER"));
        data.add(new WriteBeen(R.drawable.profession_truckdrivers_write, "TRUCK DRIVER"));
        return data;
    }

    public static ArrayList<WriteBeen> getFromSports_() {
        ArrayList<WriteBeen> data = new ArrayList<>();
        data.add(new WriteBeen(R.drawable.sport_cricket_write, "CRICKET"));
        data.add(new WriteBeen(R.drawable.sport_football_write, "FOOTBALL"));
        data.add(new WriteBeen(R.drawable.sport_polo_write, "POLO"));
        data.add(new WriteBeen(R.drawable.sport_archery_write, "ARCHERY"));
        data.add(new WriteBeen(R.drawable.sport_baseball_write, "BASEBALL"));
        data.add(new WriteBeen(R.drawable.sport_boxer_write, "BOXER"));
        data.add(new WriteBeen(R.drawable.sport_cycling_write, "CYCLING"));
        data.add(new WriteBeen(R.drawable.sport_golf_write, "GOLF"));
        data.add(new WriteBeen(R.drawable.sport_horse_raching_write, "HORSE RACING"));
        data.add(new WriteBeen(R.drawable.sport_surfing_write, "SURFING"));
        data.add(new WriteBeen(R.drawable.sport_swimming_write, "SWIMMING"));
        data.add(new WriteBeen(R.drawable.sport_tennis_write, "TENNIS"));
        data.add(new WriteBeen(R.drawable.sport_yoga_write, "YOGA"));
        return data;
    }

    public static ArrayList<WriteBeen> getFromBirds_() {
        ArrayList<WriteBeen> data = new ArrayList<>();
        data.add(new WriteBeen(R.drawable.bird_albatross_write, "ALBATROSS"));
        data.add(new WriteBeen(R.drawable.bird_bulbul_write, "BULBUL"));
        data.add(new WriteBeen(R.drawable.bird_cormorant_write, "CORMORANT"));
        data.add(new WriteBeen(R.drawable.bird_duks_write, "DUCKS"));
        data.add(new WriteBeen(R.drawable.bird_finches_write, "FINCHES"));
        data.add(new WriteBeen(R.drawable.bird_fowl_write, "FOWL"));
        data.add(new WriteBeen(R.drawable.bird_goose_write, "GOOSE"));
        data.add(new WriteBeen(R.drawable.bird_heron_write, "HERON"));
        data.add(new WriteBeen(R.drawable.bird_hornbill_write, "HORNBILL"));
        data.add(new WriteBeen(R.drawable.bird_hummingbird_write, "HUMMINGBIRD"));
        data.add(new WriteBeen(R.drawable.bird_kingfisher_write, "KINGFISHER"));
        data.add(new WriteBeen(R.drawable.bird_lbis_write, "IBIS"));
        data.add(new WriteBeen(R.drawable.bird_moa_write, "MOA"));
        data.add(new WriteBeen(R.drawable.bird_owl_write, "OWL"));
        data.add(new WriteBeen(R.drawable.bird_paradise_write_write, "PARADISE"));
        data.add(new WriteBeen(R.drawable.bird_parrot_write, "PARROT"));
        data.add(new WriteBeen(R.drawable.bird_pigeons_and_doves_write, "DOVE"));
        return data;
    }

    public static ArrayList<WriteBeen> getFromVegetable_() {
        ArrayList<WriteBeen> data = new ArrayList<>();
        data.add(new WriteBeen(R.drawable.vagitable_aubergines_write, "AUBERGINES"));
        data.add(new WriteBeen(R.drawable.vagitable_broccoli_write, "BROCCOLI"));
        data.add(new WriteBeen(R.drawable.vagitable_cabbage_write, "CABBAGE"));
        data.add(new WriteBeen(R.drawable.vagitable_carrot_write, "CARROT"));
        data.add(new WriteBeen(R.drawable.vagitable_cauliflower_write, "CAULIFLOWER"));
        data.add(new WriteBeen(R.drawable.vagitable_celery_write, "CELERY"));
        data.add(new WriteBeen(R.drawable.vagitable_corn_write, "CORN"));
        data.add(new WriteBeen(R.drawable.vagitable_green_bean_write, "GREEN BEAN"));
        data.add(new WriteBeen(R.drawable.vagitable_green_pepper_write, "GREEN PEPPER"));
        data.add(new WriteBeen(R.drawable.vagitable_lettuce_write, "LETTUCE"));
        data.add(new WriteBeen(R.drawable.vagitable_patatoes_write, "POTATOES"));
        data.add(new WriteBeen(R.drawable.vagitable_pumpkin_write, "PUMPKIN"));
        data.add(new WriteBeen(R.drawable.vagitable_radish_write, "RADISH"));
        data.add(new WriteBeen(R.drawable.vagitable_red_pepper_write, "RED PEPPER"));
        data.add(new WriteBeen(R.drawable.vagitable_sweet_patatoes_write, "SWEET POTATOES"));
        data.add(new WriteBeen(R.drawable.vagitable_tomatoes_write, "TOMATO"));
        return data;
    }

    public static ArrayList<WriteBeen> getFromDays_() {
        ArrayList<WriteBeen> data = new ArrayList<>();
        data.add(new WriteBeen(R.drawable.day_monday_write, "MONDAY"));
        data.add(new WriteBeen(R.drawable.day_tuesday_write, "TUESDAY"));
        data.add(new WriteBeen(R.drawable.day_wednesday_write, "WEDNESDAY"));
        data.add(new WriteBeen(R.drawable.day_thursday_write, "THURSDAY"));
        data.add(new WriteBeen(R.drawable.day_friday_write, "FRIDAY"));
        data.add(new WriteBeen(R.drawable.day_saturday_write, "SATURDAY"));
        data.add(new WriteBeen(R.drawable.day_sunday_write, "SUNDAY"));
        return data;
    }

    public static ArrayList<WriteBeen> getFromBodyParts_() {
        ArrayList<WriteBeen> data = new ArrayList<>();
        data.add(new WriteBeen(R.drawable.body_hair_write, "HAIR"));
        data.add(new WriteBeen(R.drawable.body_eye_write, "EYE"));
        data.add(new WriteBeen(R.drawable.body_hend_write, "HAND"));
        data.add(new WriteBeen(R.drawable.body_ear_write, "EAR"));
        data.add(new WriteBeen(R.drawable.body_lips_write, "LIP"));
        data.add(new WriteBeen(R.drawable.body_nose_write, "NOSE"));
        data.add(new WriteBeen(R.drawable.body_arm_write, "ARM"));
        data.add(new WriteBeen(R.drawable.body_foot_write, "FOOT"));
        data.add(new WriteBeen(R.drawable.body_shoulders_write, "SHOULDER"));
        data.add(new WriteBeen(R.drawable.body_finger_write, "FINGER"));
        data.add(new WriteBeen(R.drawable.body_mounth_write, "MOUTH"));
        data.add(new WriteBeen(R.drawable.body_leg_write, "LEG"));
        data.add(new WriteBeen(R.drawable.body_stomach_write, "STOMACH"));
        data.add(new WriteBeen(R.drawable.body_tongue_write, "TONGUE"));
        return data;
    }

    public static ArrayList<WriteBeen> getFromFlower_() {
        ArrayList<WriteBeen> data = new ArrayList<>();
        data.add(new WriteBeen(R.drawable.flower_amaryllis_write, "AMARYLLIS"));
        data.add(new WriteBeen(R.drawable.flower_bellflowers_write, "BELL FLOWERS"));
        data.add(new WriteBeen(R.drawable.flower_crocus_write, "CROCUS"));
        data.add(new WriteBeen(R.drawable.flower_golden_rayed_lily_write, "GOLDEN RAYED LILY"));
        data.add(new WriteBeen(R.drawable.flower_jasmine_write, "JASMINE"));
        data.add(new WriteBeen(R.drawable.flower_marigold_write, "MARIGOLD"));
        data.add(new WriteBeen(R.drawable.flower_rose_write, "ROSE"));
        data.add(new WriteBeen(R.drawable.flower_sun_flowers_write, "SUN FLOWER"));
        return data;
    }

    public static ArrayList<WriteBeen> getFromBuilding_() {
        ArrayList<WriteBeen> data = new ArrayList<>();
        data.add(new WriteBeen(R.drawable.building_bus_station_write, "BUS STATION"));
        data.add(new WriteBeen(R.drawable.building_fire_station_write, "FIRE STATION"));
        data.add(new WriteBeen(R.drawable.building_flat_write, "FLAT"));
        data.add(new WriteBeen(R.drawable.building_hospital_write, "HOSPITAL"));
        data.add(new WriteBeen(R.drawable.building_house_write, "HOUSE"));
        data.add(new WriteBeen(R.drawable.building_police_station_write, "POLICE STATION"));
        data.add(new WriteBeen(R.drawable.building_train_station_write, "TRAIN STATION"));
        return data;
    }

    public static ArrayList<WriteBeen> getFromFruitTree_() {
        ArrayList<WriteBeen> data = new ArrayList<>();
        data.add(new WriteBeen(R.drawable.tree_almond_write, "ALMOND"));
        data.add(new WriteBeen(R.drawable.tree_avocado_write, "AVOCADO"));
        data.add(new WriteBeen(R.drawable.tree_strawberry_write, "BLACKBERRY"));
        data.add(new WriteBeen(R.drawable.tree_banana_write, "BANANA"));
        data.add(new WriteBeen(R.drawable.tree_chiku_tree_write, "CHIKU"));
        data.add(new WriteBeen(R.drawable.tree_coconut_tree_write, "COCONUT"));
        data.add(new WriteBeen(R.drawable.tree_guava_write, "GUAVA"));
        data.add(new WriteBeen(R.drawable.tree_lemon_tree_write, "LEMON"));
        data.add(new WriteBeen(R.drawable.tree_mango_tree_write, "MANGO"));
        data.add(new WriteBeen(R.drawable.tree_orange_tree_write, "ORANGE"));
        data.add(new WriteBeen(R.drawable.tree_papaya_tree_write, "PAPAYA"));
        data.add(new WriteBeen(R.drawable.tree_pinaple_tree_write, "PINEAPPLE"));
        data.add(new WriteBeen(R.drawable.tree_star_fruit_write, "STAR FRUIT"));
        data.add(new WriteBeen(R.drawable.tree_strawberry_write, "STRAWBERRY"));
        data.add(new WriteBeen(R.drawable.tree_sugar_apple_write, "SUGAR APPLE"));
        return data;
    }

    public static ArrayList<WriteBeen> getFromColors_() {
        ArrayList<WriteBeen> data = new ArrayList<>();
        data.add(new WriteBeen(R.drawable.color_apple_write, ""));
        data.add(new WriteBeen(R.drawable.color_apple_write, ""));
        data.add(new WriteBeen(R.drawable.color_apple_write, ""));
        data.add(new WriteBeen(R.drawable.color_apple_write, ""));
        data.add(new WriteBeen(R.drawable.color_apple_write, ""));
        data.add(new WriteBeen(R.drawable.color_apple_write, ""));
        data.add(new WriteBeen(R.drawable.color_apple_write, ""));
        return data;
    }

    /********************* Read End *********************/
}

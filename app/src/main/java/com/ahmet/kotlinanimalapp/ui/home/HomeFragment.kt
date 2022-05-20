package com.ahmet.kotlinanimalapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.ahmet.kotlinanimalapp.Adaptery
import com.ahmet.kotlinanimalapp.R
import com.ahmet.kotlinanimalapp.databinding.FragmentHomeBinding
import com.ahmet.kotlinanimalapp.interfaces.HomeClick
import com.ahmet.kotlinanimalapp.model.Model

class HomeFragment : Fragment(), HomeClick {
     lateinit var models: ArrayList<Model>
    private lateinit var adaptery: Adaptery


    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root


        homeViewModel.text.observe(viewLifecycleOwner) {

        }
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        models = ArrayList<Model>()


        var kopek = Model(
            "KÖPEK", R.drawable.kopek,
            "Yavru Köpek Aşıları:\n\n İç ve Dış Parazit Aşısı: 6-8 hafta\n" +
                    "\n" +
                    "Puppy DP Aşısı (Karma Aşı): 6-8 hafta\n" +
                    "\n" +
                    "Karma Aşı 2. Doz: 9-12 hafta\n" +
                    "\n" +
                    "Bordotella Bronchiseptica Aşısı: 9-12 hafta\n" +
                    "\n" +
                    "İç Parazit Tekrar: 9-12 hafta\n" +
                    "\n" +
                    "Bronşin-KC Aşısı: 9-12 hafta\n" +
                    "\n" +
                    "Karma Tekrar: 12-14 hafta\n" +
                    "\n" +
                    "Kuduz Aşısı: 12-14 hafta\n" +
                    "\n" +
                    "Lyme Aşısı: 12-14 hafta\n\n" + "Yetişkin Köpek Aşıları:\n \n Kuduz aşısı: Kuduz aşıları diğer ülkelerde 3 yılda bir tekrarlanırken ülkemizde yılda 1 kere yapılması istenmektedir.\n" +
                    "\n" +
                    "Karma aşı: Birçok hastalığa karşı koruyucu özellik taşıyan karma aşının da her sene yapılması gerekmektedir.\n" +
                    "\n" +
                    "Bordotella aşısı: Koruyuculuğu bir yıl olan bu aşının da özellikle dışarı çıkan köpeklerde her yıl  tekrarlanması gerekmektedir.\n" +
                    "\n" +
                    "İç parazit aşısı: İç parazit aşılarının koruyuculuğu az olduğu için 3 ayda bir tekrarlanması istenebilir.",
            "Eğer yavru bir köpek besliyorsanız anne sütü ile beslenmesi şarttır. Anne sütü verilemiyorsa köpeğe bu dönemde günlük sütler verilebilir. Bu şekilde gelişimine katkı sağlanacaktır. " +
                    "\n\nGünde en az 2 litre su tüketmesi köpekler için önemlidir.\nKöpeklerin Sevdiği Besinler Nelerdir?\n" +
                    "\n" +
                    "Köpeklerinize mama dışında verebileceğiniz gıdalar vardır. Köpekler bu gıdaları çok sever ve keyifle tüketir.\n" +
                    "\n" +
                    "Pirinç: Yumuşak gıdalardan olan pirinç köpekler tarafından kolayca tüketilir. Dilerseniz pirinci farklı baharatlarla da pişirebilirsiniz.\n" +
                    "\n" +
                    "Et: Köpeklerin en sevdiği besinlerden biridir. Eti pişirmenize gerek yoktur. Direkt olarak verebilirsiniz.\n" +
                    "\n" +
                    "Muz: Köpeğin sevdiği bir diğer besin ise muzdur. Muzun köpek sağlığına olumlu etkisi vardır.",
            "Günlük bakımlar: Gezinme sonrası pati, karın, göğüs altı ve popo temizliği, ağız ve diş temizliği, göz bakımı, köpeğiniz Pug gibi kıvrımlı bir cins ise kıvrım aralarının günlük temizliği\n\n" +
                    "Haftalık bakımlar: Kulak bakımı, köpeğin türüne göre de değişmesi koşulu ile haftada 2-3 defa olmak üzere tüy tarama\n\n" +
                    "Aylık bakımlar: Tırnak bakımı, aylık banyo (kış mevsiminde süre 1,5-2 aya kadar çekilebilir)\n\n" +
                    "Üç ayda bir: Gerekiyorsa anal kese temizliği\n\n" +
                    "Altı ayda bir: Köpeğiniz çift kürklü değilse ve tüylerinin tıraş edilme gerekliliği bulunuyorsa tıraş\n" +
                    "Tüm bunlara ek olarak kullandığı yatağın, yastığın, eşyaların ve bulunduğu yerlerin düzenli temizliği ve bakımı",
            "Köpek için rahat bir ortam sağla\n\n" +
                    "Köpeğini tara ve besle\n\n" +
                    "Olumlu pekiştirme eğitimini uygula\n\n" +
                    "Yaramazlık yaptığında köpeğini cezalandırmaktan kaçın\n\n" +
                    "Köpeğini sosyalleştir\n\nKöpeğinin neler yapmayı sevdiğini öğren\n\n" +
                    "Köpeğine şefkat göster"
        )
        models.add(kopek)
        var kedi = Model(
            "KEDİ",
            R.drawable.kedi,
            "Yavrular, yaklaşık 16 haftalık olana kadar düzenli aşı olurlar. 6 ila 8 haftalık olduklarında aşı olmaya başlarlar.\n" +
                    "6 haftalıkken Karma Aşı-1\n\n9 haftalık olduğunda Karma Aşı-2 uygulanmalıdır\n\n10 haftalık olup zevkle oyunlar oynarken yaptıracağınız Lösemi-1 aşısıyla onu kedi lösemisinden koruyabilirsiniz. \n \n" +
                    "12 haftalık olduğu zaman kuduz aşısını uygulayacaktır. \n\n3 haftalık olan kediniz için Lösemi Aşısı-2 de yapılır ve lösemi aşısı ilk yıl için biter. \n\n" +
                    "16 haftalık olduğu zaman veterineriniz kedinize kedi aşıları arasında en önemli aşılardan biri olan FIV Aşısı’nı uygular.\n\n" +
                    "Yavru kediniz büyüyüp yetişkin bir kedi olduğunda her yıl 1 kez tekrarlamanız gereken aşılar bulunur. Yetişkin kedi aşı takvimi içinde Karma, Kuduz ve  Lösemi Aşısı yer alır. Kediniz 1 yaşını geçtikten" +
                    " sonra bu aşıların her yıl 1 kez tekrarlanması gerekir. Ayrıca, şirin arkadaşınız dışarı çıkmasa bile her iki ayda bir dış parazit ve iç parazit aşısı yapılmalı.",
            "Sahipleneceğiniz kedinin mümkünse iki aya yakın anne sütü aldığına, daha erken annesinden ayrılmadığına emin olun. Eğer bu sürede bir nedenle anne sütü alamadıysa mutlaka bir veterinere danışarak onun yaş grubuna uygun mamayı az ama sık sık vermelisiniz.\n\n" +
                    "Hem yavru hem de yetişkin kedilerde kendi yaş grubuna göre mama seçimi yapılması önemli bir nokta. Kedilerin ihtiyacına göre mamaların içeriği de farklı farklı oluşturuluyor ve sağlığına uygun oluyor. Kedinin kronik hastalığının olup olmadığı, kilosu ve cinsi de mama seçiminde önemli kriterlerden.\n\n" +
                    "Kedi beslenmesinde tartışılan noktalardan biri de ev yemeği verilip verilemeyeceği. Kediler et, tavuk ve balık severler. Ama bunları olabildiğince kılçıksız ve kemiksiz vermeye çalışın. Eğer sizin yediklerinizden isterlerse yağsız, baharatsız ve şekersiz olanlardan az az tattırabilirsiniz. Çiğ yiyecek vermemeye ve bozulma ihtimali olmayan yiyecekler olmasına özen gösterin." +
                    " Kedilerin sindirim sistemi için evinizde mutlaka kedi çimi de yetiştirmelisiniz. Bu sayede metabolizmaları daha sağlıklı olacaktır.",
            "Mama kabı ve su temizliği, şebeke suyu kullanmamak\n\n" +
                    "Oyun zamanları için uygun oyuncaklar edinmek ve bunların temizliği ile ilgilenmek\n\n" +
                    "Kedilerin saklanma istekleri için uygun, güvenli bölgeler inşa etmek\n\n" +
                    "Kedilerin tırnaklarını törpüleyebilmesi ve geçirebilmesi kedi tırmalama tahtası bulundurmak\n\n" +
                    "Sindirim sistemleri için gerekli olan faydalı otlara kedilerin erişebilmesini sağlamak. Evde kediotu bulundurmak\n\n" +
                    "Tuvaletleri için uygun kedi kumlarından kullanmak. Kanserojen kristal yapılı kedi kumları gibi yanlış tercihlerden uzak durmak. Kedi kumunun her daim temizliğinden emin olmak\n\n" +
                    "Tüy bakımları için doğru ürünler kullanmak ve tüyleri düzenli olarak fırçalamak\n\n" +
                    "Veteriner ziyaretlerini aksatmamak, aşılarını düzenli olarak yaptırmak\n\n" +
                    "Tüylerini her fırçalamada kontrol etmek, dış parazitlerin varlığında vakit kaybetmeden önlem almak\n\n" +
                    "Kedinize bir veterinerlik ziyareti esnasında mikroçip uygulamasını yaptırmak\n\n" +
                    "Diş bakımları için gereni yerine getirmek. Diş taşlarının oluşmasını ve dişlerin çürümesini engellemek için düzenli olarak kedilerin dişlerini fırçalamak.\n\n" +
                    "Kedinizin dönemine uygun şekilde en iyi bakımı üstlenmek. Yavru, hasta, gebe, yaşlı kedilerde bakımlar farklı olacaktır. Her türlü durum için uygun ortam ve koşulu sağlamak kedi sahibinin görevlerindendir.",
            "Sürekli yanınızda olması\n" +
                    "\n" +
                    "Kediniz sizi odadan odaya takip ediyor, özellikle vakit geçirdiğiniz odada bulunuyor ve uyuduğunuz odada uyuyorsa sizinle ilgileniyor ve sizinle zaman geçirmek istiyor demektir. Bazı kediler fiziksel olarak sevgilerini gösteremeyebilir, ama sadece “yanınızda” olmaları bile yeter, değil mi?\n\n" +
                    "\n" +
                    "Küçük bir ısırık alıyorsa\n" +
                    "\n" +
                    "Kediniz sizinle oynarken elinizi küçük bir şekilde ısırıyorsa emin olun bu durum sizi sevdiğindendir. Sizi incitmeyecek şekilde ısırması size karşı olan hislerinin bir göstergesidir.\n\n" +
                    "\n" +
                    "Size hediye getirmesi\n" +
                    "\n" +
                    "Günün birinde sevgili ponçiğiniz kapı eşiğinize ölü bir fare ya da ölü bir kuş getirirse ona kızmayın. Bu, onun sizin için avlanıp sizin için bir hediye getirmesi anlayışıdır ve kedi dünyasında yüce bir sevgi göstermesidir.\n\n" +
                    "\n" +
                    "Mırlıyorsa\n\n" +
                    "Kediler mutlu olduklarında mırlarlar. Onları sevdiğinizde, onlarla ilgilendiğinizde mutlu olduklarını belirtmelerinin bir yolu da çıkardıkları seslerdir. Mırlamanın kuvveti mutluluğun büyüklüğüyle orantılı olabilir."
        )
        models.add(kedi)
        var at = Model("AT", R.drawable.at, "TAYLAR\n\n6 AYLIK:Kuduz aşısı,Tetanoz ,Influenza,EHV 1,4 ve Sakağı aşıları\n\n7 AYLIK:Influenza,EHV 1,4 ve Sakağı aşıları\n\n12 AYLIK:Influenza,EHV 1,4,Kuduz aşıları\n\n" +
                "6 aylık aralıklarla Sakağı,Influenza,EHV 1,4 ve Tetanoz aşıları tekrarlanmalıdır.\n\nKuduz aşısının yılda tek sefer yapılması yeterlidir.\n" +
                "\nGEBE KISRAKLAR\n\nEHV 1,4  :5.,7. ve 9. aylarda yapılmalıdır.\n\nINFLUENZA :10. ayda yapılmalıdır.\n\nSAKAĞI : Eğer bulunduğu bölgede bu hastalık varsa aşımdan önce yapılmalıdır.\n" +
                "\nYETİŞKİN ATLAR\n\nEHV 1,4 :Yılda iki uygulama yapılır\n\nINFLUENZA :Yılda iki uygulama yapılır\n\nTETANOZ :Yılda iki uygulama yapılır.\n\nKUDUZ :Yılda tek uygulama yapılır.\n\nSAKAĞI :Yılda iki uygulama yapılır.",
            "Atlar arpa, saman, buğday ve şeker pancarı ile beslenir. Tahıl ise atların temel beslenmesini oluşturur. Atların ağırlığının arttırılması için tahıl tüketmesi gerekir. Atların ayrıca proteinde alması gerekir. At yapı olarak heybetli bir hayvandır. Ama mide yapısı daha küçüktür." +
                    " Beslenmesinin sistemli ve kontrollü olması gerekir. Tükettiği saman kalitesinin de yüksek olması gerekir. Tükettiği samanın kalitesinin yüksek olmasına önem vermek gerekir. Atların tükettiği besinlerin taze olmasına özen göstermek gerekir.\n\n" +
                    "Atlara kuru ot verilmelidir. Çünkü kuru otlar doğal besindir ve topraktan arındırılmıştır. Yeşil ot yediklerinde, toprakta yerler. Bu da at için sağlıklı bir durum değildir. Ayrıca atlar elma ve havuç gibi gıdaları severek tüketirler. Ayrıca atların su tüketimine önem vermek gerekir.",
            "Tımara başlarken, atın göreceği şekilde yaklaşılır ve ata seslenerek rahatlatılır.\n\n" +
                    "Tımara daima atın sol boynundan başlanır. Atın boynundan sonra vücudu, karın altı, bacakları sırayla temizlenir. Sonra aynı şekilde atın sağ tarafına da aynı işlemler uygulanır.\n\n" +
                    "Sol elimize vücut fırçası sağ elimize ise gebre alındıktan sonra gebre ile dairesel hareketlerle tüylerin arasındaki maddeler açığa çıkarılır ve vücut fırçasıyla ortaya çıkan pislikler tüylerin çıkış yönüne doğru fırçalanarak temizlenir.\n\n" +
                    "Gebre ve fırça ile tüm vücut temizlendikten sonra kuyruk/yele fırçasıyla yele ve kuyruk fırçalanarak temizlenir. Yele ve kuyruk, derin olmayan kalın dişli tarak ile taranmalıdır.\n\n" +
                    "Nemli bir sünger ile atın yüzü ve burnu temizlenir.\n\n" +
                    "Başka bir sünger ile kuyruk altı temizlenir.\n\n" +
                    "Tüm vücudun tımar işlemi bittikten sonra çok az nemli bir havlu ile atın vücudunu silmelisiniz.\n\n" +
                    "En son tırnakların bakımında, maya demiri ile tırnaklar temizlenir ve yağlanır.", "Sizi karşılamak için gelmesi\n\n" +
                    "Sizi görünce kişnemeye başlaması\n\nBaşını Size Yaslaması\n\nBaşı ile Dürtmesi\n\nÇevrenizde Rahat Davranıyor\n\n" +
                    "Yüzüne Doğru Nefes Alıyor\n\n ATINIZ BUNLARI YAPIYORSA SİZİNLE BAĞ KURMUŞ DEMEKTİR")
        models.add(at)
        var balik = Model("BALIK", R.drawable.balik, "Balıklarda paraziti önlemek için düzenli olarak ilaçlama yapılmalıdır. Hastalıklardan korunmak için tuzlama yapıp, yabancı yerlerden balık satın almamaya özen gösterilmelidir. Mümkünse bütün balıklar aynı yerden alınmalıdır. " +
                "Biriken artık maddelerin kısmen atılması ve eksilen minerallerin tamamlanması açısından 1/3 oranındaki düzenli su değişimleri çok önemlidir." +
                " Bir akvaryum hortumu aracılığıyla akvaryumunuzun suyunun 1/3'ünü boşaltıp, yerine dolduracağınız, temiz bir kapta üzeri açık dinlenmiş suya, balık sağlığını tehdit eden klor ve ağır metalleri etkisizleştirmek için iyi bir su hazırlayıcı preparat eklemek gerekir.",
            "Balıklarda paraziti önlemek için düzenli olarak ilaçlama yapılmalıdır. Hastalıklardan korunmak için tuzlama yapıp, yabancı yerlerden balık satın almamaya özen gösterilmelidir. Mümkünse bütün balıklar aynı yerden alınmalıdır." +
                    " Biriken artık maddelerin kısmen atılması ve eksilen minerallerin tamamlanması açısından 1/3 oranındaki düzenli su değişimleri çok önemlidir. Bir akvaryum hortumu aracılığıyla akvaryumunuzun suyunun 1/3'ünü boşaltıp, yerine dolduracağınız," +
                    " temiz bir kapta üzeri açık dinlenmiş suya, balık sağlığını tehdit eden klor ve ağır metalleri etkisizleştirmek için iyi bir su hazırlayıcı preparat eklemek gerekir.",
            "Sabah ışıklar açıldıktan 15-20 dk sonra balıklar kendine gelir. Bizim de kendimize sormamız gereken sorular şunlardır:\n" +
                    " \n\n" +
                    "* Renklerinde veya vücutlarında bir anormallik var mı?\n\n" +
                    "* Hırpalanmış bir balık var mı?\n\n" +
                    "* Dışkıları normal mi?\n\n" +
                    "* Solungaçların ikisi de düzgün mü çalışmakta?\n\n" +
                    "* Üreme durumunda olan var mı?\n\n" +
                    "* Hepsi, rahat şekilde yem yiyebiliyor mu?\n\n" +
                    "* Diğerlerini rahatsız eden bir balık var mı?\n\n" +
                    "* Suyun ısısı ne durumda\n\n" +
                    "* Filtreler ve hava motorları çalışıyor mu?", "Evinde akvaryum bulunan bir çocuk sosyalleşir ve başka bir canlıyla ilişki kurmayı öğrenir,  eğer hayvanın canını yakarsa hayvan da onun canını yakabilir böylelikle\n" +
                    "empati kurma duygusunu rahatça edinebilir. Başka bir canlının ihtiyaçlarına saygı duymayı öğrenir. Böylelikle bir çocuk için sabırlı olmayı, isteklerini ertelemeyi öğreneceği en güzel yöntem olarak akvaryum balığı hobisi önerebiliriz.")
        models.add(balik)
        var hamster = Model("HAMSTER", R.drawable.hamster, "Aşı yapılmasa bile veterinere götürmeyi ihmal etmeyin!\n\n" +
                "Hamsterların ömrü ortalama olarak 2,5-3 yıl arasında değişiyor ve bu nedenle hamsterların veteriner kontrolleri arasında çok uzun ara vermemek gerekiyor. İdeal olan 6 ayda bir kontrole götürülmesi ancak eğer 6 ayda bir götüremiyorsanız size tavsiyemiz senelik kontrollerini asla aksatmamanız.",
            "Vejetaryen olan bu dostlarımızın beslenmesi aslında çok kolay. Fındık, fıstık, ceviz, kaju, buğday gibi çerezlere bayılırlar. Dişlerini törpüleyebilmeleri için bu gibi sert gıdalarla beslenmesi gerekir. Ek olarak, besin ve vitamin almaları için haftada birkaç kez lahana, marul, havuç, patates, haşlanmış yumurta, muz gibi takviyeler verebilirsiniz." +
                    " Küçük bedenlerinin sindirebileceği yiyecekler tüketmesi ve ölçülü beslenmesi önemlidir.\n\nSebze ya da meyve yediklerinde ihtiyacı olan suyu alırlar fakat çerez tükettiklerinde de az miktarda suya ihtiyaç duyarlar. " +
                    "İçine düşme ihtimaline karşın suyu, kap yerine hamster suluklarında verilmelidir ve suyu sürekli taze tutulmalıdır.", "Titizlik hastası olan bu sempatik dostlarımız tuvalet temizliklerine oldukça dikkat ederler. Yaşam alanlarını sürekli temiz tutmaya çalıştıkları için kafes temizliğini sıklıkla yapmak gerekiyor. " +
                    "Bunun için kafesin alt ekine atölyelerden ucuza temin edebileceğiniz ağaç talaşları sıkıştırabilirsiniz.\n\nKemirme ve idrarın emilmesi nedeniyle tahta kafesler yerine tel kafesleri tercih etmek gerekir. Hareketli canlılar oldukları için koşu tekerleğini çok severler. Kalıcı felç riskine karşın bu sağlıkları açısından da bulundurulması gereken aksesuardır." +
                    " Tekerleklerinin sıklık ve gevşekliğine göre hızını ayarlayabilirsiniz. Çok hızlı olursa minik bedenleri bu tempoya dayanamayabilir. Tekerlekten ses gelirse sakın yağlamayın, yoksa duramaz! Zaten ne kadar koştuklarını tekerleğin sesinden anlarlar.",
            "Hamsterlar keşfetmeyi çok sever, meraklı, hareketli ve titizlerdir. Mahremiyetine düşkün olduklarından kafeslerinde kendilerini güvende hissedebilecekleri bir alan veya saklanabilecekleri bir bölge oluşturulmalıdır. Bu güdülerini gidermeleri için çeşitli kafes aksesuarları kullanılabilir. Sahiplenme özelliklerinden dolayı kafesine parmağınızı sokarsanız muhtemelen ısırırlar." +
                    " Size ve yeni ortamına alışması için onlara birkaç gün süre tanıyın.")
        models.add(hamster)
        var kaplumbaga = Model("KAPLUMBAĞA", R.drawable.kaplumbaga, "Suyun oda sıcaklığında olmasına dikkat ediniz. Ne sıcak ne de soğuk olmamasını sağlamak için akvaryumun içerisinde derece monte ediniz. Hava sıcaklığı ne kadar uygun olursa kaplumbağaların ömrü o kadar uzun olacaktır.\n\n" +
                " Kaplumbağaları beslerken kullandığınız yemin kaliteli olmasına dikkat ediniz ve mutlaka yem seçimi için veterinere danışarak satın alınız.\n\n" +
                "Su kaplumbağaları, kabuklarının sağlığı açısından düzenli olarak güneşe çıkarılmalıdır. Günde ortalama 1,5 saat, 15-20’şer dakikalık periyotlarla güneşe çıkardığınız kaplumbağalarınızın dilediğinde su içinde olmasına ve fazla kurumamasına özen göstermelisiniz.",
            "Su kaplumbağaları, hepçil hayvanlardır. yani hem etçil hem de otçul beslenmeye ihtiyaç duyarlar. Su kaplumbağanıza her gün az miktarda yem vermelisiniz.\n\n" +
                    " Bu yemler genellikle deniz ürünleri ve bitkileri içerir. \n\n" +
                    "Su kaplumbağanıza her gün düzenli olarak verdiğiniz yemlerin yanında, haftada 3 gün gibi bir periyot belirleyerek farklı gıdalar da sunmalısınız. Bu gıdalar haşlanmış balık, tavuk karides gibi havyansal protein içeren seçeneklerin yanında, marul ve taze yeşillikler gibi bitkisel tercihler olmalıdır. "
            , "Kaplumbağanın kabuğunu temizlemek için akan musluk suyunu ılık suya sabitleyerek, kaplumbağayı lavaboya koyabilir ve diş fırçası yardımıyla kabuğunu fırçalayabilirsiniz.\n\n" +
                    "Akvaryum içerisine sadece su koymayınız. Kaplumbağanın su dışına çıkması ve dinlenmesi  için mutlaka suyun üzerinde duracak bir kaya olmalıdır.\n\n" +
                    "Petshoptan satın aldığınızda palmiye şeklini almış plastik bir malzeme sunulursa bu kabı asla tercih etmeyiniz. Çünkü bu kaplumbağaların ömrünün kısa olmasına ve kısa sürede ölmesine neden olmaktadır.\n\n" +
                    " Kış uykusuna yatan kaplumbağalar ölmüş gibi gözükebilir bu durumdan korkmayınız belli dönemlerde kaplumbağaların kış uykusuna yattığı bilgisini unutmayınız.",
            "SU KAPLUMBAĞASI SOSYALLEŞMEYİ PEK SEVMEZ \n\n" +
                    "Su kaplumbağaları için uygun bir ortam ve beslenme sağlamanın ötesinde, çok fazla dikkat gerektirmezler, ancak düzenli etkileşim, özellikle harita kaplumbağalarıyla , evcil ve sosyal bir kaplumbağa ile sonuçlanabilir .\n\n" +
                    "Encyclopedia Britannica'ya göre etraflarında başka kaplumbağalar olup olmadığına genellikle aldırış etmeseler de, etkileşime girmiyor veya sosyalleşmiyorlar.")
        models.add(kaplumbaga)
        var papagan = Model("PAPAĞAN", R.drawable.papagan, "Vitamin ve destek gıdalar\n" +
                "Papağanınıza vereceğini yemlerin dışında vitaminler ve destek gıdaları da vermeyi ihmal etmemelisiniz.\n\n" +
                "Kafes sıcaklığı\n" +
                "Özellikle yaz aylarında kafes içi sıcaklığını kontrol edip gerektiğinde kafesi daha serin bir noktaya taşıyarak kafes içi sıcaklığı ideal şartlara getirebilirsiniz.\n\n" +
                "Pağağanı ışıklı bir odaya yerleştirin\n" +
                " Papağanınız için sağlıklı bir yaşam için hayati önem taşır. Sekuf karanlık bir odaya papağanı koymayın. Odanız parlaksa ve papağanınız ile etkileşime giriyorsanız rahat hissedeceksiniz. " +
                "Kafesinin pencere ile aynı seviyede olduğundan ve yeterli, yanlız kafesi yer seviyesine koymayın.",
            "Farklı besinler\n" +
                    "Papağanlar kabuklu yemişleri çok sevseler de sürekli kabuklu yemiş vermemelisiniz. Besin çeşitliliği çok önemli bir yer tutar.\n\n" +
                    "Onlar için faydalı olan besinler içerisinde brokoli, karnabahar, havuç, bezelye, elma, muz, pişmiş tavuk ve hindi eti, pişmiş yumurta ve kepekli, mısır ekmeği yer alır.",
            "Su ve yeminin temizliği\n" +
                    "Papağanın yem ve su kabını her gün temizleyip yeni yem ve su koymalısınız.\n\n" +
                    "Kafes temizliği\n" +
                    "Papağanın kafesini 2 günde bir temizleyerek sağlığını n risk altında olmasını önleyin.Kabuklu yemişler kafesin dibinde nemli bir ortam oluşturacağı için papağanınızın parazitlerden korunmasını sağlayın.\n\n" +
                    "Pençe bakımı\n" +
                    "Papağanın pençeleri ve tırnakları uzadığında kafese rahat tutunamazlar. Bu nedenle pençe bakımına dikkat etmelisiniz\n\n" +
                    "Gaga bakımı\n" +
                    "Gagası uzayan papağan yemişleri rahat bir şekilde tutamaz ve yiyemez. Bu nedenle  gagalar belirli uzunluklarda kesilmelidir.\n\nTüy bakımı\n" +
                    "Papağanlar renkli tüyleri ile bilindikleri için tüy bakımı çok önemlidir. Tüylerin solmaması için bakım spreyleri ile tüy bakımı yapmalısınız.\n\n" ,
            "Sürekli ezber yapın\n" +
                    "Papağanın sıkılmasını önlemek için sürekli olarak kelime ezberletmeye çalışın. Kelime ezberlettiğiniz zaman eğlenecektir.\n\n" +
                    "Konuşturun\n" +
                    "Papağanın hafızasını sürekli tazeleyerek konuşturun. Bu durum onun farklı yanlarını  da ön plana çıkaracaktır.\n" +
                    "\n")
        models.add(papagan)
        var tavsan = Model("TAVŞAN", R.drawable.tavsan, "1.VHS (Türkiyede yok)\n" +
                "2.Mikzamatozis (Türkiyede yok)\n" +
                "3.Kuduz (Türkiyede var.)\n\n\n" +
                "Dış parazitlere karşı (kulak uyuzu,genel uyuz,chelitelozis,akarlar vb): Ülkemizde uygulanabiliyor.\n\n" +
                "İç parazitlere karşı (mide-bağırsak kıl kurtları,şeritler-tenyalar) : Ülkemizde uygulanabiliyor.",
            "-Bebeklik döneminde 0-1 yaş arası pelet yem+saman+yonca . \n\n-Gençlik döneminde 1-5 yaş arası beslenme yeşillik ağırlıklı ama yine pelet+saman+yonca\n\n" +
                    "-Yaşlılık döneminde 5+ yaş yine bebekliği gibi beslenir. \n\n" +
                    "Tavşanlar bol saman ,kuru yonca,yeşillik,kuru hazır mama (pelet) verilmelidir.\nTavşanlara su yeterli miktarda verilmelidir.\n" +
                    "tavşana sınırsız oranda saman verilebilir\n" +
                    ".günde iki avuç kuru mama ,iki avuç kuru ot (yonca yaprağı) ,yeşil yapraklı (marul-lahana ,dereotu,maydanoz,sebze kabuğu,bürüksel lahanası,yeşil fasulye,enginar,karnabahar yaprakları) verilebilir.\n" +
                    "Yarım havuç günlük ve salatalık tavşanlara günde 3 kez farklı yeşillik verilir 3kg’lık tavşana 1 kg yeşillik.\n" +
                    "Hazır tavşan mamalarında mineral ve protein açısından zengin pelletler ve buğday ,arpa karışımı günde 1-2 avuç yer ama fazla besleme tavşanlarda şişmanlık obesite olmasına neden olur.",
            "Tavşanlarda banyo kesinlikle yasaktır.\n" +
                    "Su temiz olmalı ve gün aşırı değiştirilmelidir.su sabit devrilmeyen kaplarda verilmeli ve asla soğuk olmamalıdır.Tavşanların sebzelerden aldıkları su oranı kesinlikle yetersizdir ilave suya ihtiyaç duyarlar.Tavşanlar günlük 300-600 ml su tüketirler.\n" +
                    "Hijyen kurallarının dikkatli uygulanması gerekmektedir.Özellikle dışkı ve idrar alanları temiz olmalıdır. \n",
            "Tavşanlar elle enseden diğer el ile bacaklardan kavranarak tutulmalıdır bel kemiği ve ayak kırılma riski vardır.Tavşan kendini emniyette hissetmelidir arka ayakları yere basmalıdır. \n" +
                    "Tavşanlar ısıya çok duyarlıdır bu tür termal ısı değişikliklerinde vücut ısıları tavşanların yükselir ve solunum güçlükleri başlar acil olarak veteriner hekime başvurmak gereklidir.Bu esnada ıslak havluya sarmak,serin ortama almak,bol su vermek faydalı olacaktır. ")
        models.add(tavsan)
        var tavuk = Model("TAVUK", R.drawable.tavuk, "1.AŞI\t2.GÜN\n\tCANLI ND B1+ H120\tSPREY\n\n" +
                "2.AŞI\t8.GÜN\n\tİNAKTİF ND + IBD ( GAGA KESİMİ)\tENSE BÖLGESİNE, S.C, 0.5 CC\n\n" +
                "3.AŞI\t16.GÜN\n\t1.CANLI GUMBORO\tİÇME SUYUNA\n\n" +
                "4.AŞI\t23.GÜN\n\t2.CANLI GUMBORO\tİÇME SUYUNA\n\n" +
                "5.AŞI\t30.GÜN\n\tCANLI ND VH ( VEBA)\tİÇME SUYUNA\n\n" +
                "6.AŞI\t49.GÜN\n\tCANLI IB MA 5 ( BRONŞİT )\tİÇME SUYUNA\n\n" +
                "7.AŞI\t60.GÜN\n\tCANLI TİFO\tENSE BÖLGESİ, S.C, 0,2 CC\n\n" +
                "8.AŞI\t60.GÜN\n\tİNAKTİF CORYZA\tGÖĞÜS BÖLGESİNE 0,5 CC I.M.\n\n" +
                "9.AŞI\t60.GÜN\n\tCANLI ND VH ( VEBA)\tGÖZE DAMLATMA\n\n" +
                "10.AŞI\t79.GÜN\n\tCANLI IB H120 ( BRONŞİT )\tİÇME SUYUNA\n\n" +
                "11.AŞI\t88.GÜN\n\tCANLI ND VH ( VEBA)\tİÇME SUYUNA\n\n" +
                "12.AŞI\t112.GÜN\n\tİNAKTİF IB+ND+EDS\tGÖĞÜS BÖLGESİNE 0,5 CC I.M.\n\n" +
                "13.AŞI\t112.GÜN\n\tCANLI ÇİÇEK + AE\tKANAT ALTI ZARINA W.W.\n\n" +
                " \tSEVKİYAT ANINDA\t* DÖRTLÜ KARMA AŞI + TİFO\tBUDDAN VE ENSE BÖLGESİNE\n" +
                " \t \t* VEBA + BRONŞİT + YUMURTALIK SENDROMU AŞISI + CORYZA AŞISI",
            "Tavukların en fazla tükettikleri arpa, mısır ve buğday gibi tahıl ürünlerini ana besin olarak tüketirler. Bunların haricinde meyve ve sebzeleri de tüketebilirler.\n" +
                    " Tavuklar, solucan gibi yer altında yaşayan canlılarla da kendileri bularak beslenirler. " +
                    "Tavukların beslenmesinde doğal yemler tercih edilir.\nTavukların yetersiz veya yanlış beslenmesi bazı problemlerin hatta ölümlere bile sebep olabilmektedir. \n" +
                    "Meyve, sebze, peynir, Yemek artıkları (bozulmamış veya fazla yağlı olmayan), ot, çim, yonca, ağaç yaprakları da tavuklara besin olarak verilebilir.",
            "• Bütün altlık,yem,gübre…kümesten atılır.\n" +
                    "• Tozlar süpürülerek mekanik temizlik sağlanır.\n" +
                    "• Su tesisatı vb. boşaltılıp(pas,kir..)yıkanır.(basınçlı su verilir.)\n" +
                    "• Bütün yüzeyler deterjan/dezenfektanla yıkanır.\n" +
                    "• Yıkama materyali temizlenir. (buhar ve basınçlı su kullanılabilir.)Yem deposunda da artan yem çıkarılıp yapısına uygun dezenfektanla dezenfekte edilir.",
            "• Her bakımdan güvenilir damızlıkların civcivi alınır.\n" +
                    "• Aynı kümeste aynı yaşta hayvanlar olmalıdır.\n" +
                    "• Kümese yeni hayvanlar koyulmadan önce altlık ve gübreler atılmalı ,kümes ve ekipmanlar iyice temizlenip dezenfekte edilmelidir.\n" +
                    "• Aynı çiftlikte sadece bir tür kanatlı yetiştirilmelidir.\n" +
                    "• Ölenler imha fırınlarında yakılmalı veya derin çukurlara gömülmelidir.(necropsidensonra)\n" +
                    "• Kemirgenler, yabaniler ve insektleriçin önlemler alınır.\n" +
                    "• Muntazam bir aşılama programı uygulanır.")
        models.add(tavuk)
        var esek = Model("EŞEK", R.drawable.esek, "Eşekler toynakları ve dişleri, parazit kontrolü, yaralanmalar ve hastalıklar için ara sıra veteriner kontrolüne ihtiyaç duyarlar.\n" +
                " Onu tetanoz, at gribi ve kuduza karşı aşılamak şarttır. \n" +
                "Yılda üç kez veya büyüdükçe toynaklarını kesmek için bir nalbant tutmanız gerekecek",
            "Eşek, günün 12 ila 16 saatini otlayarak geçirir. \nDiyetini esas olarak yazın otlaklarından elde edilen bitkilerden oluşturur: Deve dikeni, diken, alıç ve dişbudak, karaağaç veya gürgen dallarında ziyafet çeker.\n" +
                    "Kışın yiyecekleri çoğunlukla samandır. \n" +
                    " Günde ortalama 5 kilo yiyor. Eşek obeziteye yatkın olduğu için çok zengin beslememeye dikkat edin. \n" +
                    "Susuzluğunu gidermek için emrinde daima temiz su olması gerekir. Eşeklerin de mineral alımına ihtiyacı vardır. Barınağında asılı duran bir tuz taşı bu katkıyı sağlar.",
            " Kuru, sert bir zemini sabit tutun. \n" +
                    " Kışın eşeğin arkasına bir örtü koymayı düşünüyorsanız (gerçekten soğuk iklimlerde veya numune eski veya zayıfsa), çıkarmayı, kontrol etmeyi ve her gün değiştirmeyi unutmayın.\n" +
                    "Yemlik alanını temiz tutun. \n" +
                    "Alanı sağlam bir çitle çevreleyin.\n" +
                    "Toynakları kuru ve kesilmiş tutun. \n" +
                    "Keskin kenarlar için dişlerinizi kontrol edin.",
            "Bir eşeği asla yalnız bırakmayın çünkü yalnızlığa dayanamaz ve aptalca şeyler yaparak size haber verir. Başka eşeğiniz yoksa, ona bir tavuk, bir koyun veya bir keçi refakatçi olarak sunabilirsiniz. İki eşeği birlikte çiftleştirmeyi seçerseniz, üreme problemleriyle karşılaşmamak için iki dişi tercih edin." +
                    " İki erkek alırsanız kavga şansı artar. Eşeğinizin çayırları evinizden uzakta bulunuyorsa, çok uzakta olmadığınızı bilmek ve onunla her şeyin yolunda olduğundan emin olmak isteyen hayvanınızı düzenli olarak ziyaret etmeyi unutmayın. Bir eşeği evlat edinmek, barınağını temizlemek ve ona bakmak için günde en az 30 dakika ayırabilmek demektir.")
        models.add(esek)
        var ordek=Model("ÖRDEK",R.drawable.ordek,"Hastalıklar genellikle ölümcüldür. Bir ishal ya da soğuk algınlığı bile tedavi edilmez ise ölüme neden olabilir. Tabi bu durumda en mantıklısı hastalık gelmeden önce önlemler almaktır. Bunlar yaşadığım yerin temiz tutulması en önemli unsurdur. Sadece yaşadığı yer ile sınırlı kalmayın, yemi, içeceği su, yüzeceği su temiz olmalı.\n" +
                "Ayrıca en iyi ve etkili tedavi ise aşıdır.","Ördek marul, maydanoz, brokoli, lahana ve ıspanak yer. Ispanak en sevdiği yeşilliktir. Ördekler daha çok ot obur beslenen canlılardır. Sindirim sistemleri sebze ağırlıklı beslenmeye daha uygundur. Yeşillik dışında ördek yemi tüketirler. Ördekler yeşillikleri çok sevmelerine balıkta yerler. Balık dışında baklagilleri severler. Ördekler her türlü yiyeceği tüketirler. Ama onların dengeli beslenmesi için sebze ve yem ağırlıklı beslenmesi gerekir. Çünkü sindirim sistemleri çok hassastır.",
        "Ördekler temizliğini aslında kendileri yaparlar. Kuyruklarının hemen üstünde bulunan bezeden yağ ve toz alarak onları hiç üşenmeden her bir tüyüne sürerler, bi nevi krem gibi düşünün.  Ama bu yetmez, onların yüzebileceği bir su da lazım. Ve bu su büyük bir leğende ona tahsis ettiğiniz bir su ise düzenli olarak temizlenmesi gerekir. Bu konuyu küçümsemeyin. Ördeklerin gerçekten yüzmeye ihtiyaçlarına vardır.\n" +
                "Ördeğiniz daha yavru iken sizin onu sık sık yıkamanız gerekir. Yıkadıktan sonra temiz bir örtü ile kurulayın, iyice kuruyana kadar sıcak bir ortamda kalması gerekir, yoksa hasta olur.",
        "Ördeklerin düzenli olarak dolaşması ve ayaklarını çalıştırması gerekir. Bunun yanı sıra güneş ışığına da ihtiyaçları vardır.\n" +
                "Ördek tek başına bakıldığı zaman çok viklediğinden ve sürekli sizle olmak istediğinden dolayı yanına bir arkadaş daha almanızda fayda var. Ama şunu belirtmeliyim ki arkadaşı daha yavru iken almanız lazım, çünkü dediğimde gibi büyüyünce hırçın oluyorlar ve yavruları ya da kardeşleri (yani kendi soyundan birileri) dışında diyer ördekler ile kavga edebiliyorlar.\n")
        models.add(ordek)
        var yilan=Model("YILAN",R.drawable.yilan,"Yılanlar, nemli ve sıcak ortamları sever. Bu yüzden yaşam alanlarının 30 derece civarında olması gerekir. Yılan bakımında ısı değişimleri evcil dostunuzun sağlığını ciddi olarak etkiler. Bu nedenle yılanınızın yaşadığı ortamda ısı sabit olmalıdır. Yılanlar, akvaryumda yaşayabilirler ama geniş bir ortam da rahatça hareket etmek isteyeceklerdir. Akvaryumun zemini kum ya da talaşla kaplı olmalıdır. Yılanlar tehlike altında olduklarını hissettiklerinde saklanmak isterler. Yılanın yaşam alanında saklanabileceği kaya, ot ya da benzeri doğal malzemeler bulunan karanlık bir alan olmalıdır. Genellikle gün ışığı onlar için yeterli olur. Fakat yılanınızın güneş ışığına doğrudan temas etmediğinden emin olun.",
        "Bildiğiniz gibi bazı yılanlar ağaçta, diğerleri ise yerde yaşarlar. Ağaçta yaşayan yılanlar dışında, diğerleri tamamen etçil beslenirler. Yılanlar doğaları gereği canlı olan hayvanlarla beslendiği için evde yılan bakımı oldukça zor olabilir.\n\n" +
                "Ağaç yılanları dışında tüm yılanlar etçildir. Evcil hayvanlar arasında tercih yaparken yılanın tükettiği besinleri ve beslenme koşullarını mutlaka dikkate almalısınız. Yılanlar, hayatta olan canlılarla beslendiği için onları beslemek oldukça zordur. Yılanı her zaman canlı bir organizmayla beslemek mümkün olamayacağından yılan sahiplenmek isteyenler dondurulmuş ya da yeni ölmüş canlılar da kullanmak zorunda kalır. Dondurulmuş avlar hazır paketler halinde satılmaktadır ama bunlar yılana verilmeden önce mutlaka ılık suda tamamen çözdürülmelidirler. Yılanlar, canlı avları yedikleri için dondurulmuş avlar ilgilerini çekmeyebilir. Bu durumda çözdürülmüş av tavuk ya da et suyuna batırılıp yılana verilmelidir.",
        "Normalde yılanlar geniş akvaryumda/dayanıklı kutuda veya yılanlara özel teraryumda (yılanların boyu zaman geçtikçe daha çok uzadığı için büyük akvaryum tercih edin) rahatlıkla yaşayabilirler ama akvaryumun içini dört dörtlük dizayn etmelisiniz.\n\n" +
                "Akvaryumun alt kısmı (zemin) yılana uygun kum, ufak taşlar veya talaşlarla kaplı olması gerekir. Yılanların ürkütücü olduğuna bakmayın, aslında kendilerini tehlike altında hissettiklerinde saklanacak yer ararlar. Dolayısıyla akvaryumun içine kaya, dekoratif evler, ağaçlar veya büyük otlar gibi nesneler bulunmalıdır. Yılanınız karanlık ortam istediğinde bu nesnelerin içine girerek rahatlıkla dinlenebilir.",
        "Yılan bakımı kolay değildir. Çünkü, yılan diğer evcil hayvanlardan çok farklı, özel bir canlıdır ve yılanın beslenme alışkanlıkları ile bakımı da diğer evcil dostlarımızdan oldukça uzaktır. Yılan sahiplenirken yavru olması avantajdır. Çünkü yavruyken sahiplenilen yılan sahibine çabuk alışır ve eğitilmesi daha kolay olur.")
        models.add(yilan)
        var kertenkele=Model("KERTENKELE",R.drawable.kertenkele,"Bu canlıların diyetleri çoğunlukla meyve ve böceklerden oluşur. Neyse ki, uzman veterinerlerde veya evcil hayvan dükkanlarından özel olarak hazırlanmış yemleri makul fiyatlarda bulabilirsiniz. Ancak buna rağmen, öğünlerine cırcır böceği, hamam böceği veya solucan gibi bazı canlı yemleri ekleyebilirsiniz. Ne de olsa kertenkeleler yırtıcı hayvanlardır.\n" +
                "\n" +
                " kertenkeleler %60 ile %80 arasında nem oranına ve 18°C ile 28°C arasında bir sıcaklığa ihtiyaç duyarlar. Sıcaklığı bir termostatla kolayca kontrol edebilirsiniz, ancak nemi ölçmek ve ayarlamak daha karmaşık bir konudur.",
        "Kertenkele beslemek istiyorsanız mutlaka kertenkeleyi uygun bir yerde muhafaza etmelisiniz. Dilerseniz kertenkeleyi bir fanus veya akvaryum içerisinde besleyebilirsiniz. Kertenkele börtü böceklerden çok hoşlanır ve afiyetle yer. Beslenmesi için börtü böcek veyahut sebze de verebilirsiniz. Eğer yırtıcı bir kertenkele besliyorsanız hayvan yemi de vererek besleyebilirsiniz.\n" +
                "\n" +
                "Kertenkele çabuk büyüyen bir canlıdır. Dolayısıyla suya da çok ihtiyaç duyarlar. Vereceğiniz hayvan yemi ile birlikte yanında su da ilave edebilirsiniz. Böylece kertenkele hızlı bir şekilde büyüyüp sağlıklı bir şekilde beslenecektir. Kertenkele hızlı büyüyen ve çabuk gelişen canlılardır. Bu yüzden beslenmesine çok dikkat edilmelidir.\n",
        "Cam teraryum: Cam teraryumlar nem seviyelerini biraz daha iyi koruma eğilimindedir.\n" +
                "Günlük sulama: Teraryumunuzu günde iki sprey uçlu bir su şişesi ile ıslatınız. Bu yalnızca nem seviyesinin korunmasına yardımcı olmakla kalmaz, aynı zamanda kertenkelenin doğal ortamını uyarır.\n" +
                "Teraryuma bol miktarda bitki ve bitki örtüsü yerleştirin.\n" +
                "Otomatik sulama sistemi kullanın: Bu sistem pahalı olabilir fakat kesinlikle çok daha etkilidir. Bir kere alacağınız bu sistem, bütün teraryuma otomatik su püskürtecektir.\n" +
                "Teraryuma bir adet higrometre yerleştirin: Cama yapışan bir higrometre alın, böylece kolaylıkla nem seviyesini ölçersiniz. Bunlar çok kullanışlı ve pahalı olmayan çözümlerdir.\n" +
                "Teraryumunuzun tabanında, Hindistan cevizi lifi gibi nem tutan bir alt tabaka kullanın.",
        "Küçük boyutlarına ve güzel görünüşlerine rağmen,  kertenkeleler dünya üzerindeki en dayanıklı sürüngenlerden biridir. Ancak, diğer bütün egzotik hayvanlarda da olduğu gibi,  kertenkelelerin hayatta kalabilmeleri için çok kontrollü bir ortamda yaşamaya ihtiyaçları vardır. ")
        models.add(kertenkele)

        binding.recyclerView.layoutManager = GridLayoutManager(context, 2)
        adaptery = Adaptery(models, this)
        binding.recyclerView.adapter = adaptery


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun itemCLickListener(model: Model) {
        val action=HomeFragmentDirections.actionNavigationHomeToNavigationDashboard(model)
        findNavController(this).navigate(action)
    }
}
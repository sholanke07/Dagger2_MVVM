package com.lateef.daggermvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.lateef.daggermvvm.BindingMultiplyDaggerMVVM.BindingFactory.DaggerViewModelFactory
import com.lateef.daggermvvm.BindingMultiplyDaggerMVVM.BindingViewModel.BindingViewModel1
import com.lateef.daggermvvm.BindingMultiplyDaggerMVVM.BindingViewModel.BindingViewModel2
import com.lateef.daggermvvm.di.DaggerMyComponent
//import com.lateef.daggermvvm.di.DaggerMyComponent
import com.lateef.daggermvvm.factory.MyViewModelFactory
import com.lateef.daggermvvm.viewmodel.MyViewModel
import dagger.*
import dagger.multibindings.IntoMap
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject
import kotlin.reflect.KClass

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var factory: ViewModelProvider.Factory
    //@Inject
    lateinit var myViewModel: MyViewModel
    lateinit var bindingViewModel1: BindingViewModel1
    lateinit var bindingViewModel2: BindingViewModel2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        DaggerMyComponent.create().inject(this)

        myViewModel = ViewModelProviders.of(this, factory).get(MyViewModel::class.java)

       // textval.text = myViewModel.getDataViewModel()

       /* myViewModel.callLiveData()
        myViewModel.getMyLiveData().observe(this, Observer {
           textval.text = it
        })*/

        DaggerMyMultiComponent.create().inject(this)

        bindingViewModel1 = ViewModelProviders.of(this, factory).get(BindingViewModel1::class.java)
        bindingViewModel2 = ViewModelProviders.of(this, factory).get(BindingViewModel2::class.java)
        
        bindingViewModel1.callData()
        bindingViewModel1.getMutableLiveDataString().observe(this, Observer {
            textval.setText(it)
        })
        bindingViewModel2.callData()
        bindingViewModel2.getMutableLiveDataString().observe(this, Observer {
            textval2.setText(it)
        })
    }
}
@Module
abstract class MyModule{

    @Binds
    abstract fun bindViewModelFactory(factory: MyViewModelFactory): ViewModelProvider.Factory
}

@Component(modules = [MultiBindModule::class])
interface MyMultiComponent{
    fun inject (activity: MainActivity)
}


@Module
internal abstract class MultiBindModule{
    @Binds
    abstract fun bindMultiViewModelFactory(factory: DaggerViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(BindingViewModel1::class)
    abstract fun bindmainViewModel1(bindingViewModel1: BindingViewModel1): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(BindingViewModel2::class)
    abstract fun bindmainViewModel2(bindingViewModel2: BindingViewModel2): ViewModel
}

@MustBeDocumented
@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
@MapKey
internal annotation class ViewModelKey(val value: KClass<out ViewModel>)

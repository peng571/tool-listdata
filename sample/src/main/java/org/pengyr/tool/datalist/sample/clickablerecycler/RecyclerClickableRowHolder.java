package org.pengyr.tool.datalist.sample.clickablerecycler;

import android.databinding.ViewDataBinding;

import org.pengyr.tool.datalist.recycler.ModelRowHolder;
import org.pengyr.tool.datalist.sample.BR;
import org.pengyr.tool.datalist.sample.model.SampleContainer;
import org.pengyr.tool.datalist.sample.model.pojo.SampleObject;

/**
 * Created by Peng on 2018/4/15.
 */

public class RecyclerClickableRowHolder extends ModelRowHolder<Long> {

    private final ViewDataBinding binding;

    private final SampleObject emptySampleObject = new SampleObject(0, "Empty Object");

    public RecyclerClickableRowHolder(ViewDataBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    @Override protected void bind(int position, Long object) {
        super.bind(position, object);
        SampleObject sampleObject = SampleContainer.getInstance().get(object, emptySampleObject);
        binding.setVariable(BR.data, sampleObject);
        binding.executePendingBindings();
    }

}
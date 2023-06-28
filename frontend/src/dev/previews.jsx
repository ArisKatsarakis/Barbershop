import React from 'react'
import {ComponentPreview, Previews} from '@react-buddy/ide-toolbox'
import {PaletteTree} from './palette'
import {RendevouzTable} from "../Components/RendevouzTable";
import {CreateOrderButton} from "../Components/CreateOrderButton";

const ComponentPreviews = () => {
    return (
        <Previews palette={<PaletteTree/>}>
            <ComponentPreview path="/RendevouzTable">
                <RendevouzTable/>
            </ComponentPreview>
            <ComponentPreview path="/CreateOrderButton">
                <CreateOrderButton/>
            </ComponentPreview>
        </Previews>
    )
}

export default ComponentPreviews